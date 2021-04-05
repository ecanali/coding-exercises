from django.contrib import admin
from .models import Recipe, File

# Register your models here.
admin.site.register(Recipe)
admin.site.register(File)