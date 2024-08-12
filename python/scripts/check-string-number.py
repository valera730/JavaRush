def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

print(isfloat('n17'))
print(isfloat('11.23'))