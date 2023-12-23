def convertToBinary(n):
   if n > 1:
       convertToBinary(n//2)
   print(n % 2,end = '')

dec = 49

convertToBinary(dec)
print()