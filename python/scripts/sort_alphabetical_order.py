my_str = "Hello this Is an Example With cased letters"

words = [word.lower() for word in my_str.split()]

words.sort()

print("After sorting:")
for word in words:
   print(word)