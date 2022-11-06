import re

my_string  = " Some string "
output = re.sub(r'^\s+|\s+$', '', my_string)

print(output)