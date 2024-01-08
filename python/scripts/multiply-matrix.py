X = [[31, 8, 2],
    [5, 7, 1],
    [2, 3, 3]]

Y = [[2,9,7,11],
    [7,8,25,12],
    [6,5,3,7]]

result = [[0,0,0,0],
         [0,0,0,0],
         [0,0,0,0]]

for i in range(len(X)):
   for j in range(len(Y[0])):
       for k in range(len(Y)):
           result[i][j] += X[i][k] * Y[k][j]

for r in result:
   print(r)