from functools import reduce

my_list = [[75], [17, 21], [23, 59, 26, 11]]
print(reduce(lambda x, y: x+y, my_list))