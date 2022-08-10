def recur_sum(n):
   if n <= 1:
       return n
   else:
       return n + recur_sum(n-1)
num = 16

if num < 0:
   print("Введите положительное число")
else:
   print("Сумма: ",recur_sum(num))