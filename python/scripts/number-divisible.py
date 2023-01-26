my_list = [13, 64, 57, 41, 105, 325, 121,]

result = list(filter(lambda x: (x % 13 == 0), my_list))

print("Numbers divisible by 13 are", result)