import json

from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse


from .models import User, Recipe, File


def index(request):
    recipes = Recipe.objects.all()
    files = File.objects.all()

    return render(request, "capstone/index.html", {
        'recipes': recipes,
        'files': files
    })


def recipes(request):
    recipes = Recipe.objects.all()
    files = File.objects.all()

    return render(request, "capstone/recipes.html", {
        'recipes': recipes,
        'files': files
    })


def recipe(request, id):
    recipe = Recipe.objects.get(pk=id)
    files = File.objects.filter(recipe=id)

    return render(request, "capstone/recipe.html", {
        'recipe': recipe,
        'files': files
    })


def about(request):
    return render(request, "capstone/about.html")


@login_required(redirect_field_name=None, login_url='/admin/login')
def myrecipes(request):
    user = User.objects.get(pk=request.user.id)
    recipes = Recipe.objects.filter(owner=user)
    files = File.objects.all()

    return render(request, "capstone/admin/recipes/index.html", {
        'recipes': recipes,
        'files': files
    })


@login_required(redirect_field_name=None, login_url='/admin/login')
def myrecipe(request, id):
    recipe = Recipe.objects.get(pk=id)
    files = File.objects.filter(recipe=id)

    return render(request, "capstone/admin/recipes/recipe.html", {
        'recipe': recipe,
        'files': files
    })


@login_required(redirect_field_name=None, login_url='/admin/login')
def create_view(request):
    if request.method == "POST":
        user = User.objects.get(pk=request.user.id)

        recipe = Recipe(
            title=request.POST["title"],
            chef=request.POST["chef"],
            ingredients=request.POST["ingredients"],
            preparation=request.POST["preparation"],
            information=request.POST["information"],
            owner=user
        )
        recipe.save()

        files = request.FILES.getlist('photos')
        for file in files:
            new_file = File(
                file=file,
                name=file,
                path=f'/static/capstone/images/{file}'.replace(" ", "_"),
                recipe=recipe
            )
            new_file.save()
 
        return HttpResponseRedirect(reverse("myrecipe", args=(recipe.id,)))

    else:        
        return render(request, "capstone/admin/recipes/create.html")


@login_required(redirect_field_name=None, login_url='/admin/login')
def edit_view(request, id):
    recipe = Recipe.objects.get(pk=id)
    files = File.objects.filter(recipe=id)
    user = User.objects.get(pk=request.user.id)
    
    if request.method == "PUT":
        # Ensure a user can't edit anyone's recipe 
        if user == recipe.owner:
            # Update post content into database
            data = json.loads(request.body)

            recipe.title = data["title"],
            recipe.chef = data["chef"],
            recipe.ingredients = data["ingredients"],
            recipe.preparation = data["preparation"],
            recipe.information = data["information"]

            recipe.save()

            # return HttpResponse(status=204)
            return HttpResponseRedirect(reverse("myrecipe", args=(recipe.id,)))

        else:
            return HttpResponseRedirect(reverse("myrecipes")) 

    else:        
        return render(request, "capstone/admin/recipes/edit.html", {
            'recipe': recipe,
            'files': files
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

            return HttpResponseRedirect(reverse("myrecipes"))

        else:
            return render(request, "capstone/admin/session/login.html", {
                "message": "Invalid username and/or password."
            })
    else:
        return render(request, "capstone/admin/session/login.html")


def register(request):
    if request.method == "POST":
        username = request.POST["username"]
        email = request.POST["email"]

        # Ensure password matches confirmation
        password = request.POST["password"]
        confirmation = request.POST["confirmation"]
        if password != confirmation:
            return render(request, "capstone/admin/session/register.html", {
                "message": "Passwords must match."
            })

        # Attempt to create new user
        try:
            user = User.objects.create_user(username, email, password)
            user.save()
        except IntegrityError:
            return render(request, "capstone/admin/session/register.html", {
                "message": "Username already taken."
            })
        login(request, user)

        return HttpResponseRedirect(reverse("myrecipes"))

    else:
        return render(request, "capstone/admin/session/register.html")


def logout_view(request):
    logout(request)
    return HttpResponseRedirect(reverse("index"))
