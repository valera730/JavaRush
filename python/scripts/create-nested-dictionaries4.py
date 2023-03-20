import os
try:
    os.makedirs("/catalog/inner_dir")
except FileExistsError:
    print("Catalog already exists")