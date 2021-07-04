import sys

people = sys.stdin.readline()
time = sorted(list(map(int, sys.stdin.readline().split())))


time_sum = 0
_time = []

for i in time:
    time_sum += i
    _time.append(time_sum)
print(sum(_time))
