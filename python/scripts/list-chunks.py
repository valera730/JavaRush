def split(list_a, chunk_size):

  for i in range(0, len(list_a), chunk_size):
    yield list_a[i:i + chunk_size]

chunk_size = 2
my_list = [112,24,74,23,15,41,76,85,96]
print(list(split(my_list, chunk_size)))