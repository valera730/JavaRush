import glob, os

os.chdir("catalog")

for file in glob.glob("*.txt"):
    print(file)