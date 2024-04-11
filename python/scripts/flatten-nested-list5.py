from functools import reduce

my_list = [[47], [12, 64], [72, 36, 97, 101]]
print(reduce(lambda x, y: x+y, my_list))