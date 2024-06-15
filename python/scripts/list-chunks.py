def split(list_a, chunk_size):

  for i in range(0, len(list_a), chunk_size):
    yield list_a[i:i + chunk_size]

chunk_size = 2
my_list = [54,17,21,97,18,34,27,15,11]
print(list(split(my_list, chunk_size)))