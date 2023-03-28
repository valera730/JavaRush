from functools import reduce

my_list = [[5], [3, 5], [2, 3, 4, 7]]
print(reduce(lambda x, y: x+y, my_list))