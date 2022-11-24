import os

file_stat = os.stat('filename.ext')
print(file_stat.st_size)