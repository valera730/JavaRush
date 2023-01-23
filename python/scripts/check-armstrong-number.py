num = 1234

order = len(str(num))

sum = 0

temp = num
while temp > 0:
   digit = temp % 10
   sum += digit ** order
   temp //= 10

if num == sum:
   print(num," Armstrong number")
else:
   print(num," not a Armstrong number")