X = [[6, 5, 3],
    [9, 3, 1],
    [27, 23, 11]]

Y = [[25,14,17,11],
    [23,15,5,1],
    [15,18,11,23]]

result = [[sum(a*b for a,b in zip(X_row,Y_col)) for Y_col in zip(*Y)] for X_row in X]

for r in result:
   print(r)