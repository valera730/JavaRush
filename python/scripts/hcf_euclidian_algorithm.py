def compute_hcf(x, y):
   while(y):
       x, y = y, x % y
   return x

hcf = compute_hcf(17, 2990)
print("The HCF is", hcf)