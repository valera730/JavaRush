X = [[17, 2],
    [2, 8],
    [6, 5]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)