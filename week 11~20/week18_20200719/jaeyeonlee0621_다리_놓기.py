import sys

n = int(sys.stdin.readline())

for _ in range(n):
    start, end = list(map(int, sys.stdin.readline().split()))
    if start > end: start, end = end, start

    answer = 1
    for _ in range(start):
        answer *= end
        end -= 1

    for i in range(1, start + 1):
        answer //= i

    print(answer)