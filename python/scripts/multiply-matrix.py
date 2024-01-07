X = [[23, 7, 4],
    [3, 5, 2],
    [1, 2, 5]]

Y = [[1,8,9,10],
    [5,6,23,11],
    [3,2,1,5]]

result = [[0,0,0,0],
         [0,0,0,0],
         [0,0,0,0]]

for i in range(len(X)):
   for j in range(len(Y[0])):
       for k in range(len(Y)):
           result[i][j] += X[i][k] * Y[k][j]

for r in result:
   print(r)