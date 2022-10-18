def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

print(isfloat('a56'))
print(isfloat('3.14'))