import sys

n, m = map(int, sys.stdin.readline().split())
number = list(map(int, sys.stdin.readline().split()))
number.append(0)

start, end = 0, 0
sum, answer = number[start], len(number)

while start < n and end < n:
    if sum >= m:
        answer = min(answer, end - start + 1)
        sum -= number[start]
        start += 1
        if start > end:
            end = start
            sum = number[start]
    else:
        end += 1
        sum += number[end]

print(0 if answer == len(number) else answer)
