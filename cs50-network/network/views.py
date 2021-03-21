from django import forms

from django.contrib.auth import authenticate, login, logout
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse

from .models import User, Post, Follower


class CreatePostForm(forms.Form):
    content = forms.CharField(widget=forms.Textarea(attrs={'placeholder': "What's happening?", "rows":2, 'class':'form-control'}), required=True, label='')


def index(request):
    post_form = CreatePostForm(request.POST or None)
    
    if request.method == "POST":
        if not request.user.is_authenticated:
            # messages.error(request, 'Sorry, you must log in before create a listing.')
            return HttpResponseRedirect(reverse("index"))

        user = User.objects.get(id=request.user.id)

        if post_form.is_valid():
            post = Post(
                author=user, 
                content=post_form.cleaned_data["content"]
            )
            post.save()

            return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "network/index.html", {
        "post_form": post_form,
        "posts": Post.objects.all().order_by('-id')
    })


def follow(request, user_id):
    try:

        # >>> INCLUIR VALIDAÇÃO BACK N DEIXAR PRÓPRIO USUÁRIO SE SEGUIR!

        # get current user and target user to follow/unfollow
        current_user = User.objects.get(id=request.user.id)
        target_user = User.objects.get(id=user_id)

        # remove if already following, else add the follower
        if Follower.objects.filter(user=target_user, follower=current_user).exists():
            Follower.objects.filter(user=target_user, follower=current_user).delete()
        else:
            add_follower = Follower(
                user=target_user, 
                follower=current_user
            )
            add_follower.save()
    
        return HttpResponseRedirect(reverse("profile", args=(target_user.username,)))
    except User.DoesNotExist:
        return HttpResponseRedirect(reverse("index"))


def profile_view(request, username):
    
    # INCLUIR LÓGICA PARA USUÁRIO NÃO LOGADO ACESSAR PÁGINA
    
    # Query for requested user
    try:
        user = User.objects.get(username=username)
        current_user = User.objects.get(id=request.user.id)
        is_following = False

        if Follower.objects.filter(user=user, follower=current_user).exists():
            is_following = True

        return render(request, "network/profile.html", {
            "user_posts": Post.objects.filter(author_id=user).order_by('-id'),
            "followers": len(Follower.objects.filter(user=user)),
            "following": len(Follower.objects.filter(follower=user)),
            "user_profile": user,
            "is_following": is_following
        })
    except User.DoesNotExist:
        return HttpResponseRedirect(reverse("index"))

    
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
            return render(request, "network/login.html", {
                "message": "Invalid username and/or password."
            })
    else:
        return render(request, "network/login.html")


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
            return render(request, "network/register.html", {
                "message": "Passwords must match."
            })

        # Attempt to create new user
        try:
            user = User.objects.create_user(username, email, password)
            user.save()
        except IntegrityError:
            return render(request, "network/register.html", {
                "message": "Username already taken."
            })
        login(request, user)
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "network/register.html")
