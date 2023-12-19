def factorial(x):
    if x == 1:
        return 1
    else:
        return (x * factorial(x-1))

num = 74

result = factorial(num)
print("Factorial of", num, "is", result)