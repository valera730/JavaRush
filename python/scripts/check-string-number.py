def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

print(isfloat('b32'))
print(isfloat('7.654'))