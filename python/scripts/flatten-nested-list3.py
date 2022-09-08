import itertools

my_list = [[5], [4, 6], [1, 2, 3, 6]]

flat_list = list(itertools.chain(*my_list))
print(flat_list)