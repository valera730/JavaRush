my_list = [[7], [1, 9], [2, 4, 9, 7]]

flat_list = []
for sublist in my_list:
    for num in sublist:
        flat_list.append(num)

print(flat_list)