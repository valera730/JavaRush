def recur_factorial(n):
   if n == 1:
       return n
   else:
       return n*recur_factorial(n-1)

num = 9

if num < 0:
   print("Факториал не существует для отрицательных чисел")
elif num == 0:
   print("Факторивал нуля - единица")
else:
   print("Факториал ", num, " равен ", recur_factorial(num))