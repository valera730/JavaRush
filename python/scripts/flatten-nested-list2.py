my_list = [[3], [1, 2], [6, 8, 9, 3]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)