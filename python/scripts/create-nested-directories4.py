import os
try:
    os.makedirs("/directory/inner_cat")
except FileExistsError:
    print("Catalog already exists")