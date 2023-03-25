my_list = [[4], [2, 5], [7, 9, 3, 5]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)