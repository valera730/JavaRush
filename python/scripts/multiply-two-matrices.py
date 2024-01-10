X = [[2,3,7],
    [3, 5, 2],
    [7, 3,1]]

Y = [[5,4,1,7],
    [7,5,3,2],
    [5,8,2,4]]

result = [[sum(a*b for a,b in zip(X_row,Y_col)) for Y_col in zip(*Y)] for X_row in X]

for r in result:
   print(r)