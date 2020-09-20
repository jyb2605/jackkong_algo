import sys

count, goal = map(int, sys.stdin.readline().split())

numbers = [int(sys.stdin.readline()) for _ in range(count)]
numbers.sort()

dp = [10001 for _ in range(goal + 1)]
dp[0] = 0

for n in numbers:
    for i in range(n, goal + 1):
        dp[i] = min(dp[i], dp[i - n] + 1)

print(-1 if dp[goal] == 10001 else dp[goal])
