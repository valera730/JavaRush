import os

for file in os.listdir("catalog"):
    if file.endswith(".txt"):
        print(file)