N = int(input())

N = 1000 - N
changes = [500, 100, 50, 10, 5, 1]

changesIndex = 0

count = 0

while True:
    if N >= changes[changesIndex]:
        count = count + (N // changes[changesIndex])
        N = N - (changes[changesIndex] * (N // changes[changesIndex]))

    else:
        changesIndex = changesIndex + 1

    if changesIndex == 6:
        break

print(count)