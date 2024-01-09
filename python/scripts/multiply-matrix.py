X = [[15, 6, 3],
    [2, 9, 5],
    [5, 7, 1]]

Y = [[3,7,5,3],
    [5,6,13,9],
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