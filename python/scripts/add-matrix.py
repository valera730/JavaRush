X = [[15,8,2],
    [5,6,7],
    [8 ,9,1]]

Y = [[7,3,5],
    [7,8,4],
    [6,7,3]]

result = [[0,0,0],
         [0,0,0],
         [0,0,0]]

for i in range(len(X)):
   for j in range(len(X[0])):
       result[i][j] = X[i][j] + Y[i][j]

for r in result:
   print(r)