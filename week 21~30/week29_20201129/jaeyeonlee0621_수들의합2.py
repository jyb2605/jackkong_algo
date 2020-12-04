import sys

n, m = map(int, sys.stdin.readline().split())
number = list(map(int, sys.stdin.readline().split()))
number.append(0)

start, end, = 0, 0
sum, answer = number[0], 0

while start < n and end < n:
    if sum == m:
        answer += 1
    if sum > m:
        sum -= number[start]
        start += 1
        if start > end:
            end = start
            sum = number[start]
    else:
        end += 1
        sum += number[end]

print(answer)
