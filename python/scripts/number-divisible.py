my_list = [11, 37, 49, 53, 98, 129, 99, 321]

result = list(filter(lambda x: (x % 12 == 0), my_list))

print("Numbers divisible by 12 are: ", result)