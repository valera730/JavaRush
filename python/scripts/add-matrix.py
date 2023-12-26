X = [[12,9,3],
    [8,3,5],
    [1,5,7]]

Y = [[15,11,12],
    [3,2,7],
    [5,3,1]]

result = [[0,0,0],
         [0,0,0],
         [0,0,0]]

for i in range(len(X)):
   for j in range(len(X[0])):
       result[i][j] = X[i][j] + Y[i][j]

for r in result:
   print(r)