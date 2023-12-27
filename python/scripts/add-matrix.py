X = [[21,11,7],
    [6,5,7],
    [2,9,14]]

Y = [[11,34,17],
    [31,22,21],
    [15,71,11]]

result = [[0,0,0],
         [0,0,0],
         [0,0,0]]

for i in range(len(X)):
   for j in range(len(X[0])):
       result[i][j] = X[i][j] + Y[i][j]

for r in result:
   print(r)