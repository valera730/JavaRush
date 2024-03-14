import os
try:
    os.makedirs("/dir/inner_dir")
except FileExistsError:
    print("Catalog already exists")