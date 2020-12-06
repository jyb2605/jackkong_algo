import sys

n = int(sys.stdin.readline().strip())
number = list(map(int, sys.stdin.readline().split()))

start, end, answer = 0, n - 1, [number[0], number[n - 1]]

while start < end:
    diff = number[start] + number[end]

    if abs(diff) < abs(answer[0] + answer[1]):
        answer = [number[start], number[end]]
    if diff == 0:
        break
    elif diff < 0:
        start += 1
    else:
        end -= 1

print(f'{answer[0]} {answer[1]}')
