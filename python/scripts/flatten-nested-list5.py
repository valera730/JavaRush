from functools import reduce

my_list = [[51], [4, 9], [15, 71, 83, 28]]
print(reduce(lambda x, y: x+y, my_list))