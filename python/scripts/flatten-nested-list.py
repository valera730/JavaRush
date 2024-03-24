my_list = [[3], [8, 4], [2, 1, 3, 7]]

flat_list = [num for sublist in my_list for num in sublist]
print(flat_list)