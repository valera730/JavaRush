dict_1 = {1: 'z', 2: 'f'}
dict_2 = {2: 't', 4: 'h'}

dict_3 = dict_2.copy()
dict_3.update(dict_1)

print(dict_3)