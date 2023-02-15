X = [[15,8,6],
    [5 ,7,4],
    [6 ,4,3]]

Y = [[3,7,2,4],
    [7,8,4,1],
    [5,3,6,3]]

result = [[0,0,0,0],
         [0,0,0,0],
         [0,0,0,0]]

for i in range(len(X)):
   for j in range(len(Y[0])):
       for k in range(len(Y)):
           result[i][j] += X[i][k] * Y[k][j]

for r in result:
   print(r)