import sys

n = int(sys.stdin.readline())
n_time = []

for i in range(n):
    n_time.append(tuple(map(int, sys.stdin.readline().split())))

n_time.sort(key=lambda x: (x[1], x[0]))

s = n_time[0][1]
cnt = 1
for i in range(1, len(n_time)):
    if n_time[i][0] >= s:
        cnt += 1
        s = n_time[i][1]
print(cnt)
