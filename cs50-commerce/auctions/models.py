from django.contrib.auth.models import AbstractUser
from django.db import models


# Have I changed anything here? Run `python3 manage.py makemigrations` and then `python3 manage.py migrate`


class User(AbstractUser):
    pass
# Insert Watchlist field within the User model?


# I need to have at least 3 Models in addition to the User model.

# 1 for auction listings
# must have: ID (auto created), title, description, starting prince, current price, user who bid the current price, photo, category, active or closed
class Listing(models.Model):
    title = models.CharField(max_length=64)
    description = models.CharField(max_length=128)
    starting_price = models.IntegerField()
    current_price = models.IntegerField()
    image_url = models.CharField(max_length=256)
    category_id = models.IntegerField()
    status = models.CharField(max_length=64)


# 1 for bids
# must have: ID, price bid, listing bid id, user bid id

# 1 for comments made in auction listings
# must have: ID, textarea, user id, listing id

# 1 (extra) for auction categories
# must have: ID, name of the category (e.g. consoles, games, joysticks, accessories).