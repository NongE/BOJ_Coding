import sys

n = sys.stdin.readline().rstrip()

n = n.split("-")

sum_list = []
for i in n:
    sum_list.append(sum(map(int, i.split("+"))))

answer = sum_list[0] - sum(sum_list[1:])

print(answer)
