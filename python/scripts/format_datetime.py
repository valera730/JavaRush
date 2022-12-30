from datetime import datetime

now = datetime.now()

t = now.strftime("%H:%M:%S")
print("Time:", t)

s1 = now.strftime("%m/%d/%Y, %H:%M:%S")
print("s1:", s1)

s2 = now.strftime("%d/%m/%Y, %H:%M:%S")
print("s2:", s2)