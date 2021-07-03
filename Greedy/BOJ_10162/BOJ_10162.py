N = int(input())

timer = [300, 60, 10]

timerIndex = 0

timerCount = [0, 0, 0]

flag = 0

while True:

    if N >= timer[timerIndex]:
        timerCount[timerIndex] = timerCount[timerIndex] + (N // timer[timerIndex])
        N = N - (timer[timerIndex] * (N // timer[timerIndex]))
    else:
        timerIndex = timerIndex + 1

    if timerIndex == 3:
        if N != 0:
            flag = 1
        break

if flag != 1:
    for i in range(0,3):
        print(timerCount[i])
else:
    print(-1)