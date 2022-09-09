from functools import reduce

my_list = [[4], [5, 6], [1, 2, 3, 9]]
print(reduce(lambda x, y: x+y, my_list))