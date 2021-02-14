from django import forms

from django.contrib.auth import authenticate, login, logout
from django.contrib import messages
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse

from .models import User, Category, Listing


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
    listing = Listing.objects.get(id=id)
    if request.method == "POST":
        bid_offered = int(request.POST["bid"])
        print(bid_offered)
        if bid_offered > listing.current_price:
            return HttpResponse("It worked! Work in the logic now!")
        else:
            # message = messages.add_message(request, messages.INFO, 'Hello world.')
            messages2 = messages.error(request, "Error: This is the sample error Flash message.")   
            print(messages2)

            # return HttpResponseRedirect(reverse("listing", args=(listing.id,)))
            return render(request, "auctions/listing.html", {
            "listing": listing,
            "messages": messages2
        })


    else:
        return render(request, "auctions/listing.html", {
            "listing": listing
        })

# If the user is signed in, the user should be able to bid on the item. The bid must be at least as large as the starting bid, and must be greater than any other bids that have been placed (if any). If the bid doesn’t meet those criteria, the user should be presented with an error.



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
        if form.is_valid():
            # Isolate the data from the 'cleaned' version of form data
            title = form.cleaned_data["title"]
            description = form.cleaned_data["description"]
            starting_price = form.cleaned_data["starting_price"]
            image_url = form.cleaned_data["image_url"]
            category = int(request.POST['category'])

            listing = Listing(title=title, description=description, starting_price=starting_price, current_price=starting_price, image_url=image_url, category_id=category, status="active")
            listing.save()

        # REDIRECT TO THE NEW LISTING WHEN I CREATE THAT PAGE
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "auctions/create.html", {
        "form": form
    })

