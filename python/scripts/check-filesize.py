import os

file_stat = os.stat('file.name')
print(file_stat.st_size)