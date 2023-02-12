X = [[15,8,5],
    [6 ,3,2],
    [9 ,7,6]]

Y = [[4,7,2],
    [7,9,2],
    [6,3,4]]

result = [[X[i][j] + Y[i][j]  for j in range(len(X[0]))] for i in range(len(X))]

for r in result:
   print(r)