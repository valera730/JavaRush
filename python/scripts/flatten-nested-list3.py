import itertools

my_list = [[7], [4, 11], [2, 5, 71, 28]]

flat_list = list(itertools.chain(*my_list))
print(flat_list)