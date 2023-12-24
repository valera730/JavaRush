X = [[12,6,3],
    [4,5,9],
    [1,2,3]]

Y = [[9,3,7],
    [4,2,8],
    [5,8,4]]

result = [[0,0,0],
         [0,0,0],
         [0,0,0]]

for i in range(len(X)):
   for j in range(len(X[0])):
       result[i][j] = X[i][j] + Y[i][j]

for r in result:
   print(r)