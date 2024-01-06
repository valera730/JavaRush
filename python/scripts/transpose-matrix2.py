X = [[17, 21],
    [15, 29],
    [23, 34]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)