import itertools

my_list = [[7], [5, 8], [2, 4, 3, 5]]

flat_list = list(itertools.chain(*my_list))
print(flat_list)