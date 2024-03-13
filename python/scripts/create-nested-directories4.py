import os
try:
    os.makedirs("/cat/inner_cat")
except FileExistsError:
    print("Catalog already exists")