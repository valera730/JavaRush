from datetime import time

a = time()
print("a =", a)

b = time(10, 23, 14)
print("b =", b)

c = time(hour = 10, minute = 23, second = 14)
print("c =", c)

d = time(10, 23, 14, 234567)
print("d =", d)