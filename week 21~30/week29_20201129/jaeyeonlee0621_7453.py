import sys

n = int(sys.stdin.readline().strip())

A, B, C, D = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, sys.stdin.readline().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB, CD = [], []
for i in range(n):
    for j in range(n):
        AB.append(A[i] + B[j])
        CD.append(C[i] + D[j])

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
