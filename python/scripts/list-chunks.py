def split(list_a, chunk_size):

  for i in range(0, len(list_a), chunk_size):
    yield list_a[i:i + chunk_size]

chunk_size = 2
my_list = [21,3,5,9,11,17,3,5,14]
print(list(split(my_list, chunk_size)))