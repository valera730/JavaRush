num = 31

if num < 0:
   print("Enter positive number")
else:
   sum = 0
   while(num > 0):
       sum += num
       num -= 1
   print("Sum = ", sum)