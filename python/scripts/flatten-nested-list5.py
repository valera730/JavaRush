from functools import reduce

my_list = [[23], [45, 35], [89, 71, 54, 17]]
print(reduce(lambda x, y: x+y, my_list))