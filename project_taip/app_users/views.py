from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User


# Create your views here.


def home(request):
    return render(request, "home.html", {})


def register(request):
    return render(request, "register.html", {})


def login_view(request):
    return render(request, "login.html", {})


def register_user(request):
    username = request.POST["username"]
    password = request.POST["password"]
    email = request.POST["email"]
    user = User.objects.create_user(username, email, password)
    user.save()

    return redirect("/login")


def authenticate_user(request):
    username = request.POST['username']
    password = request.POST['password']
    user = authenticate(username=username, password=password)
    if user is not None:
        login(request, user)
        return render(request, "home.html", {})
    else:
        render(request, "register.html", {"error": "Authentication failed"})


def logout_view(request):
    logout(request)
    return redirect("/")
