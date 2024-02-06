rows = int(input("Rows: "))

for i in range(rows):
    for j in range(i+1):
        print("* ", end="")
    print("\n")