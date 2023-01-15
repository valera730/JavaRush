year = 2023

if (year % 400 == 0) and (year % 100 == 0): 
    print("{0} leap year".format(year))
elif (year % 4 ==0) and (year % 100 != 0):
    print("{0} leap year".format(year)) 
else:
    print("{0} not leap year".format(year)) 