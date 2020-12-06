import sys

n = int(sys.stdin.readline().strip())

A, B, C, D = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, sys.stdin.readline().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

CD = {}
for i in range(n):
    for j in range(n):
        sum = C[i] + D[j]
        if not CD.get(sum):
            CD[sum] = 0
        CD[sum] += 1

answer = 0
for i in range(n):
    for j in range(n):
        sum = (A[i] + B[j]) * -1
        if CD.get(sum):
            answer += CD[sum]

print(answer)
