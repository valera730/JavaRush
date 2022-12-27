from datetime import datetime, date

t1 = date(year = 2022, month = 12, day = 24)
t2 = date(year = 2021, month = 12, day = 25)

t3 = t1 - t2

print("t3 =", t3)

t4 = datetime(year = 2022, month = 12, day = 21, hour = 9, minute = 12, second = 22)
t5 = datetime(year = 2021, month = 7, day = 11, hour = 7, minute = 44, second = 33)
t6 = t4 - t5
print("t6 =", t6)

print("Type of t3 =", type(t3)) 
print("Type of t6 =", type(t6))