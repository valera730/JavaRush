X = [[13,5],
    [3 ,6],
    [4 ,7]]

result = [[X[j][i] for j in range(len(X))] for i in range(len(X[0]))]

for r in result:
   print(r)