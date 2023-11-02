my_list = [37, 24, 52, 17, 67, 120, 87, 320]

result = list(filter(lambda x: (x % 12 == 0), my_list))

print("Numbers divisible by 12 are: ", result)