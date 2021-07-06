import sys

n = int(sys.stdin.readline().rstrip())

rope = []

for i in range(n):
    r = int(sys.stdin.readline().rstrip())
    rope.append(r)

rope = sorted(rope)
rope_weight = []

rope_len = len(rope)
for i in range(rope_len):
    rope_weight.append(rope[i] * (rope_len - i))

print(max(rope_weight))
