my_list = [[9], [1, 5], [3, 2, 7, 9]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)