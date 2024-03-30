my_list = [[5], [3, 4], [7, 1, 8, 27]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)