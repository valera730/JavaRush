import os

file_name = os.path.basename('/catalog/filename.ext')

print(os.path.splitext(file_name)[0])