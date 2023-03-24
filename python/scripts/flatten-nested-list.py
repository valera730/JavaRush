my_list = [[5], [7, 3], [8, 5, 5, 2]]

flat_list = [num for sublist in my_list for num in sublist]
print(flat_list)