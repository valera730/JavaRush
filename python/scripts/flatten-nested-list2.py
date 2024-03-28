my_list = [[5], [2, 7], [1, 5, 6, 2]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)