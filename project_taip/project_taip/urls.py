"""project_taip URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.10/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url
from django.contrib import admin
from app_users.views import home, register, register_user, authenticate_user, login_view, logout_view, \
    groups_view, friends_view, requests_view

urlpatterns = [
    # GET views
    url(r'^admin/', admin.site.urls),
    url(r'^register_user', register_user),
    url(r'^groups', groups_view),
    url(r'^friends', friends_view),
    url(r'^requests', requests_view),
    url(r'^login', login_view),

    # actions via POST
    url(r'^authenticate_user', authenticate_user),
    url(r'^register', register),
    url(r'^logout', logout_view),

    # root url
    url(r'^', home),

]
