X = [[21, 5],
    [3, 7],
    [5, 3]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)