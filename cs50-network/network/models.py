from django.contrib.auth.models import AbstractUser
from django.db import models


class User(AbstractUser):
    pass


# Vamos precisar armazenar as seguintes tabelas
# Posts - user, content, timestamp, likes
class Post(models.Model):
    author = models.ForeignKey("User", on_delete=models.CASCADE, related_name="posts")
    content = models.TextField(blank=True)
    timestamp = models.DateTimeField(auto_now_add=True)
    likes = models.ManyToManyField("User", related_name="liked_posts")

    def serialize(self):
        return {
            "id": self.id,
            "author": self.author,
            "content": self.content,
            "timestamp": self.timestamp.strftime("%b %d %Y, %I:%M %p"),
            "likes": [user.id for user in self.likes.all()]
        }


# User (update) - incluir lista pessoas followers, lista pessoas following
class Follower(models.Model):
    user = models.ForeignKey("User", on_delete=models.CASCADE, related_name="followers")
    follower = models.ForeignKey("User", on_delete=models.CASCADE, related_name="following")
    
    def serialize(self):
        return {
            "id": self.id,
            "user": self.user,
            "follower": self.follower
        }


# # Original / Initial
# # User (update) - incluir lista pessoas followers, lista pessoas following
# class Follower(models.Model):
#     followers = models.ManyToManyField("User", related_name="followers")
#     following = models.ManyToManyField("User", related_name="following")
    
#     def serialize(self):
#         return {
#             "id": self.id,
#             "followers": [user.id for user in self.followers.all()],
#             "following": [user.id for user in self.following.all()]
#         }
