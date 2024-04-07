from functools import reduce

my_list = [[7], [2, 6], [1, 6, 21, 17]]
print(reduce(lambda x, y: x+y, my_list))