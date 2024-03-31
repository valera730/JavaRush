import itertools

my_list = [[2], [3, 9], [3, 1, 2, 8]]

flat_list = list(itertools.chain(*my_list))
print(flat_list)