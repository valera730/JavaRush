my_list = [[69], [23, 7], [84, 27, 3, 98]]

flat_list = [num for sublist in my_list for num in sublist]
print(flat_list)