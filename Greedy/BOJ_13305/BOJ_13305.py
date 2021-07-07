import sys

n = int(sys.stdin.readline().rstrip())

city_len = list(map(int, sys.stdin.readline().rstrip().split()))

oil = list(map(int, sys.stdin.readline().rstrip().split()))

pay = 0
pay_index = 0
compare_index = 0

for i in range(1, len(oil)):
    if oil[compare_index] >= oil[i]:
        pay += city_len[pay_index] * oil[compare_index]
        compare_index = i
        pay_index += 1
    else:
        pay += city_len[pay_index] * oil[compare_index]
        pay_index += 1

print(pay)
