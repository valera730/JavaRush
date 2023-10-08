num = 34

if num == 1:
    print(num, "not a prime number")
elif num > 1:
   for i in range(2,num):
       if (num % i) == 0:
           print(num,"not a prime number")
           print(i,"times",num//i,"is",num)
           break
   else:
       print(num,"prime number")
       
else:
   print(num,"not a prime number")