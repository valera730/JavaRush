with open('file.txt') as f:
    content_list = [line for line in f]

print(content_list)

with open('file.txt') as f:
    content_list = [line.rstrip() for line in f]

print(content_list)