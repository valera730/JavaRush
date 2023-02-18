my_str = 'Inessa'

my_str = my_str.casefold()

rev_str = reversed(my_str)

if list(my_str) == list(rev_str):
   print("Palindrome")
else:
   print("Not palindrome")