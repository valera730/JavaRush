my_list = [[5], [12, 3], [91, 12, 23, 71]]

flat_list = [num for sublist in my_list for num in sublist]
print(flat_list)