import os

for root, dirs, files in os.walk("directory"):
    for file in files:
        if file.endswith(".jpg"):
            print(file)