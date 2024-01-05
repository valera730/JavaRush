X = [[7, 11],
    [3, 19],
    [3, 5]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)