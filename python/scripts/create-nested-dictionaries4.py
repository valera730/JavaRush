import os
try:
    os.makedirs("/outer_dir/inner_dir")
except FileExistsError:
    print("Directory already exists")