X = [[15, 12],
    [5, 9],
    [2, 8]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)