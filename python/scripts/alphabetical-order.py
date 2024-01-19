my_str = "Words may be derived naturally from the language's roots or formed by coinage and construction."

words = [word.lower() for word in my_str.split()]

words.sort()

print("Sorted words:")
for word in words:
   print(word)