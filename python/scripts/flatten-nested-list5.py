from functools import reduce

my_list = [[12], [3, 7], [11, 26, 25, 34]]
print(reduce(lambda x, y: x+y, my_list))