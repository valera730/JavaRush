import itertools, random

deck = list(itertools.product(range(1,14),['First','Second','Third','Fourth']))

random.shuffle(deck)

print("You got:")
for i in range(5):
   print(deck[i][0], "of", deck[i][1])