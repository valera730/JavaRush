num = 21

flag = False

if num == 1:
    print(num, " not a prime number")
elif num > 1:
    for i in range(2, num):
        if (num % i) == 0:
            flag = True
            break

    if flag:
        print(num, "not a prime number")
    else:
        print(num, "prime number")