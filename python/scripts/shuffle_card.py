import itertools, random

deck = list(itertools.product(range(1,14),['One', 'Two', 'Three', 'Four']))

random.shuffle(deck)

print("Shuffle:")
for i in range(5):
   print(deck[i][0], "of", deck[i][1])