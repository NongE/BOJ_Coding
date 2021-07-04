import sys

n, k = map(int, sys.stdin.readline().split())
money = []

for i in range(n):
    money.append(int(sys.stdin.readline()))

cnt = 0
for i in range(n):
    if money[(n-1)-i] <= k:
        s = int(k/money[(n-1)-i])
        k -= s * money[(n-1)-i]
        cnt += s
print(cnt)