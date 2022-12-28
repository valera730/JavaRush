from datetime import timedelta

t1 = timedelta(weeks = 3, days = 4, hours = 5, seconds = 36)
t2 = timedelta(days = 5, hours = 12, minutes = 14, seconds = 37)

t3 = t1 - t2

print("t3 =", t3)