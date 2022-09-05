my_list = [[3], [5, 6], [9, 7, 3, 1]]

flat_list = [num for sublist in my_list for num in sublist]
print(flat_list)