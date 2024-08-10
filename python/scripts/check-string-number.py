def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

print(isfloat('a15'))
print(isfloat('5.12'))