my_list = [32, 27, 55, 36, 17, 124, 121, 1320]

result = list(filter(lambda x: (x % 12 == 0), my_list))

print("Numbers divisible by 12 are: ", result)