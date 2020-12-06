import sys

n = int(sys.stdin.readline().strip())
m = int(sys.stdin.readline().strip())

number = list(map(int, sys.stdin.readline().split()))
number.sort()

start, end, answer = 0, n - 1, 0

while start < end:
    sum = number[start] + number[end]
    if sum == m:
        answer += 1
        start, end = start + 1, end - 1
    elif sum > m:
        end -= 1
    else:
        start += 1

print(answer)
