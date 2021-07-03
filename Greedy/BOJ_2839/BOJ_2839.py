N = int(input())

result = 0

while True:
    if N == 0: break

    if N >= 5:
       if((N % 5) % 3 != 0):
           N = N - 3
           result = result + 1
       else:
           result = result + (N // 5)
           N = N - 5 * (N//5)

    elif N == 3:
        N = N - 3
        result = result + 1

    elif N % 3 != 0:
        result = -1
        break



print(result)
