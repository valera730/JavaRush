def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

print(isfloat('b27'))
print(isfloat('4.26'))