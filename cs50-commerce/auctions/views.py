from django import forms

from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.contrib import messages
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse

from .models import User, Category, Listing, Bid, Watchlist


class CreateListingForm(forms.Form):
    title = forms.CharField(label="Title")
    description = forms.CharField(label="Description")
    starting_price = forms.IntegerField(min_value=1)
    image_url = forms.URLField(label='Image URL', required=False)
    category = forms.ModelChoiceField(queryset=Category.objects.all(), empty_label="Choose one")


def index(request):
    # ALTER TO FILTER ONLY THE REAL STATUS "ACTIVE" LISTINGS
    return render(request, "auctions/index.html", {
        "active_listing": Listing.objects.all()
    })


def listing(request, id):
    try:
        listing = Listing.objects.get(id=id)
    except:
        messages.error(request, 'Sorry, listing does not exist.')
        return HttpResponseRedirect(reverse("index"))

    if request.method == "POST":
        if not request.user.is_authenticated:
            messages.error(request, 'Sorry, you must log in before place a bid.')
            return HttpResponseRedirect(reverse("listing", args=(listing.id,)))
        bid_offered = int(request.POST["bid"])
        if bid_offered > listing.current_price:
            new_bid = Bid(price=bid_offered, listing_id=Listing.objects.get(id=id), user_id=User.objects.get(id=request.user.id))
            new_bid.save()
            listing.current_price = bid_offered
            listing.save()
            messages.success(request, 'Congratulations, now you have the highest bid.')
            return HttpResponseRedirect(reverse("listing", args=(listing.id,)))
        else:
            messages.error(request, 'Sorry, bid must be greater than the current price.')
            return HttpResponseRedirect(reverse("listing", args=(listing.id,)))
    else:
        watchlisted = False
        
        if request.user.is_authenticated:
            user = User.objects.get(id=request.user.id)
            user_watchlist = Watchlist.objects.get(user_id=user.id)

            converted_watchlist = user_watchlist.listings_watched.strip('"[]"').split(', ')

            for item in converted_watchlist:
                if str(id) == item:
                    watchlisted = True
            
        return render(request, "auctions/listing.html", {
            "listing": listing,
            "watchlisted": watchlisted
        })


def watch(request, id):
    try:
        listing = Listing.objects.get(id=id)
    except:
        messages.error(request, 'Sorry, listing does not exist.')
        return HttpResponseRedirect(reverse("index"))

    if request.method == "GET":
        if not request.user.is_authenticated:
            messages.error(request, 'Sorry, you must first log in to access your watchlist.')
            return HttpResponseRedirect(reverse("listing", args=(listing.id,)))

        user = User.objects.get(id=request.user.id)
        user_watchlist = Watchlist.objects.get(user_id=user.id)

        converted_watchlist = user_watchlist.listings_watched.strip('"[]"').split(', ')

        string_watchlist = ""
        separator = ", "
        for item in converted_watchlist:
            if str(id) == item:
                converted_watchlist.remove(item)
                string_watchlist = separator.join(converted_watchlist)
                user_watchlist.listings_watched = string_watchlist
                user_watchlist.save()
                return HttpResponseRedirect(reverse("listing", args=(listing.id,)))
            if not str(id) in converted_watchlist:
                converted_watchlist.append(str(id))
                string_watchlist = separator.join(converted_watchlist)
                user_watchlist.listings_watched = string_watchlist
                user_watchlist.save()
                return HttpResponseRedirect(reverse("listing", args=(listing.id,)))

        return HttpResponseRedirect(reverse("listing", args=(listing.id,)))


def categories(request):
    if request.method == "POST":
        filter = request.POST["filter"]
        if filter == "all":
            return render(request, "auctions/categories.html", {
                "active_listing": Listing.objects.all(),
                "categories": Category.objects.all()
            })
        else:
            return render(request, "auctions/categories.html", {
                "filter": int(filter),
                "active_listing": Listing.objects.filter(category_id=int(filter)),
                "categories": Category.objects.all()
            })
    else:
        return render(request, "auctions/categories.html", {
            "active_listing": Listing.objects.all(),
            "categories": Category.objects.all()
        })


def login_view(request):
    if request.method == "POST":

        # Attempt to sign user in
        username = request.POST["username"]
        password = request.POST["password"]
        user = authenticate(request, username=username, password=password)

        # Check if authentication successful
        if user is not None:
            login(request, user)
            return HttpResponseRedirect(reverse("index"))
        else:
            return render(request, "auctions/login.html", {
                "message": "Invalid username and/or password."
            })
    else:
        return render(request, "auctions/login.html")


def logout_view(request):
    logout(request)
    return HttpResponseRedirect(reverse("index"))


def register(request):
    if request.method == "POST":
        username = request.POST["username"]
        email = request.POST["email"]

        # Ensure password matches confirmation
        password = request.POST["password"]
        confirmation = request.POST["confirmation"]
        if password != confirmation:
            return render(request, "auctions/register.html", {
                "message": "Passwords must match."
            })

        # Attempt to create new user
        try:
            user = User.objects.create_user(username, email, password)
            user.save()
        except IntegrityError:
            return render(request, "auctions/register.html", {
                "message": "Username already taken."
            })
        login(request, user)
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "auctions/register.html")


def create(request):
    form = CreateListingForm(request.POST)
    
    if request.method == "POST":
        if not request.user.is_authenticated:
            messages.error(request, 'Sorry, you must log in before create a listing.')
            return HttpResponseRedirect(reverse("create"))
        if form.is_valid():
            # Isolate the data from the 'cleaned' version of form data
            title = form.cleaned_data["title"]
            description = form.cleaned_data["description"]
            starting_price = form.cleaned_data["starting_price"]
            image_url = form.cleaned_data["image_url"]
            category = int(request.POST['category'])

            listing = Listing(title=title, description=description, starting_price=starting_price, current_price=starting_price, image_url=image_url, category_id=category, status="active", owner_user_id=User.objects.get(id=request.user.id))
            listing.save()

        # REDIRECT TO THE NEW LISTING WHEN I CREATE THAT PAGE
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "auctions/create.html", {
        "form": form
    })

