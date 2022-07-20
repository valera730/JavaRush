num = 5

factorial = 1
if num < 0:
   print("Нет факториала для отрицательных чисел")
elif num == 0:
   print("Факториал нуля - единица")
else:
   for i in range(1,num + 1):
       factorial = factorial*i
   print("Факториал числа ",num," - ",factorial)