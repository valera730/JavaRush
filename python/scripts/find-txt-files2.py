import os

for file in os.listdir("catalog"):
    if file.endswith(".doc"):
        print(file)