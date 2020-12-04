import sys

n = int(sys.stdin.readline())
prime = [1 for _ in range(n + 1)]
prime[1] = 0
prime[0] = 0

for i in range(2, n + 1):
    if prime[i] == 0:
        continue

    number = i * 2
    while number <= n:
        prime[number] = 0
        number += i

start, end = 2, 2
sum, answer = start, 0

while start <= n and end <= n:
    if sum == n:
        answer += 1
    if sum > n:
        sum -= start
        start += 1
        while start <= n and prime[start] == 0:
            start += 1
        if start > end:
            end, sum = start, start
    else:
        end += 1
        while end <= n and prime[end] == 0:
            end += 1
        sum += end

print(answer)
