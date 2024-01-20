my_str = "Quite astonishingly, the notice was a 630 word sentence, which picked up one of our Golden Bull awards that year."

words = [word.lower() for word in my_str.split()]

words.sort()

print("Sorted words:")
for word in words:
   print(word)