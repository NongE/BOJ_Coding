import sys

L = []
P = []
V = []

while True:

    user_input = list(map(int, sys.stdin.readline().rstrip().split()))

    if user_input[0] == 0 and user_input[1] == 0 and user_input[2] == 0:
        break
    else:
        L.append(user_input[0])
        P.append(user_input[1])
        V.append(user_input[2])


for i in range(len(L)):
    if V[i] % P[i] < L[i]:
        print(f"Case {i+1}: {((V[i]//P[i]) * L[i]) + (V[i] % P[i])}")
    else:
        print(f"Case {i+1}: {((V[i]//P[i]) * L[i]) + L[i]}")
