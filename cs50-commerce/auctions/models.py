from django.db import models
from django.contrib.auth.models import AbstractUser
from django.db.models.signals import post_save
from django.dispatch import receiver


# Have I changed anything here? Run `python3 manage.py makemigrations` and then `python3 manage.py migrate`


class User(AbstractUser):
    pass
# Insert Watchlist field within the User model?


# I need to have at least 3 Models in addition to the User model.

# 1 (extra) for auction categories
# must have: ID, name of the category (e.g. consoles, games, joysticks, accessories).
class Category(models.Model):
    name = models.CharField(max_length=64)

    def __str__(self):
        return f"{self.name}"


# 1 for auction listings
# must have: ID (auto created), title, description, starting prince, current price, user who bid the current price, photo, category, active or closed
class Listing(models.Model):
    STATUS = (('active', 'Active'), ('closed', 'Closed'))

    title = models.CharField(max_length=64)
    description = models.CharField(max_length=128)
    starting_price = models.PositiveIntegerField()
    current_price = models.PositiveIntegerField()
    image_url = models.CharField(max_length=256)
    # category_id = models.PositiveIntegerField()
    category_id = models.ForeignKey(Category, on_delete=models.CASCADE)
    status = models.CharField(max_length=12, choices=STATUS, default='active')
    owner_user_id = models.ForeignKey(User, on_delete=models.CASCADE)
    # winner_id = models.PositiveIntegerField()
    winner_id = models.ForeignKey(User, on_delete=models.CASCADE, related_name="winner_user")

    def __str__(self):
        return f"Title: {self.title} / Current Price: {self.current_price} / Status: {self.status}"


class Watchlist(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    listings_watched = models.CharField(max_length=100)

    @receiver(post_save, sender=User)
    def create_user_watchlist(sender, instance, created, **kwargs):
        if created:
            Watchlist.objects.create(user=instance)

    @receiver(post_save, sender=User)
    def save_user_watchlist(sender, instance, **kwargs):
        instance.watchlist.save()
    
    def __str__(self):
        return f"{self.listings_watched}"


# 1 for bids
# must have: ID, price bid, listing bid id, user bid id
class Bid(models.Model):
    price = models.PositiveIntegerField()
    listing_id = models.ForeignKey(Listing, on_delete=models.CASCADE)
    user_id = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return f"Price: {self.price} / Listing: {self.listing_id} / User: {self.user_id}"


# 1 for comments made in auction listings
# must have: ID, textarea, user id, listing id
class Comment(models.Model):
    text = models.TextField()
    listing_id = models.ForeignKey(Listing, on_delete=models.CASCADE)
    user_id = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return f"Text: {self.text} / Listing: {self.listing_id} / User: {self.user_id}"
