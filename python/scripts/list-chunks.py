def split(list_a, chunk_size):

  for i in range(0, len(list_a), chunk_size):
    yield list_a[i:i + chunk_size]

chunk_size = 2
my_list = [3,2,4,6,5,6,9,8,7]
print(list(split(my_list, chunk_size)))