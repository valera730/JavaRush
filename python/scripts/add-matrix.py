X = [[15,7,5],
    [6,7,3],
    [2,3,5]]

Y = [[11,15,17],
    [6,4,9],
    [7,6,2]]

result = [[0,0,0],
         [0,0,0],
         [0,0,0]]

for i in range(len(X)):
   for j in range(len(X[0])):
       result[i][j] = X[i][j] + Y[i][j]

for r in result:
   print(r)