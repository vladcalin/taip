from django.db import models
from django.contrib.auth import get_user_model


# Create your models here.


class UserGroup(models.Model):
    users = models.ManyToManyField(get_user_model())
