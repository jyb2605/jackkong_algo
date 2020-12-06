import sys

n = int(sys.stdin.readline().strip())

ABCD = []
for _ in range(n):
    ABCD.append(list(map(int, sys.stdin.readline().split())))

AB, CD = [], []
for i in range(n):
    for j in range(n):
        pass

AB.sort()
CD.sort()
print(AB)
print(CD)

start, end, answer = 0, n - 1, 0
while 0 <= start < n and 0 <= end < n:
    sum = AB[start] + CD[end]
    if sum == 0:
        answer += 1
        start, end = start + 1, end - 1
    elif sum > 0:
        end -= 1
    else:
        start += 1

print(answer)
