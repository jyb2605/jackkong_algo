import sys

n = int(sys.stdin.readline().strip())

ABCD = []
for _ in range(n):
    ABCD.append(list(map(int, sys.stdin.readline().split())))

AB, CD = [], []
for i in range(n):
    for j in range(n):
        AB.append(ABCD[i][0] + ABCD[j][1])
        CD.append(ABCD[i][2] + ABCD[j][3])

AB.sort()
CD.sort()

start, end, answer = 0, len(CD) - 1, 0
while 0 <= start < len(AB) and 0 <= end < len(CD):
    sum = AB[start] + CD[end]
    if sum == 0:
        answer += 1
        start, end = start + 1, end - 1
    elif sum > 0:
        end -= 1
    else:
        start += 1

print(answer)
