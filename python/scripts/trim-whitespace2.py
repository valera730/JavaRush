import re

my_string  = " Python code "
output = re.sub(r'^\s+|\s+$', '', my_string)

print(output)