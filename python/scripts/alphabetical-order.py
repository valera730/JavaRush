my_str = "This is some string"

words = [word.lower() for word in my_str.split()]

words.sort()

print("Sorted words:")
for word in words:
   print(word)