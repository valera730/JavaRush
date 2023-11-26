def print_factors(x):
   print("Factors of ",x,": ")
   for i in range(1, x + 1):
       if x % i == 0:
           print(i)

num = 571

print_factors(num)