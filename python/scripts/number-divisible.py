my_list = [12, 63, 58, 42, 107, 327, 123, 129]

result = list(filter(lambda x: (x % 12 == 0), my_list))

print("Numbers divisible by 12 are: ", result)