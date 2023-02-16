X = [[14,5,2],
    [5 ,7,3],
    [5 ,4,3]]

Y = [[3,5,2,3],
    [9,3,2,1],
    [3,6,8,2]]

result = [[sum(a*b for a,b in zip(X_row,Y_col)) for Y_col in zip(*Y)] for X_row in X]

for r in result:
   print(r)