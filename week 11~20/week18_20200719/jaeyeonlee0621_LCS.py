import sys

source = sys.stdin.readline()[:-1]
destination = sys.stdin.readline()[:-1]

dp = [[0 for _ in range(len(source) + 1)] for _ in range(len(destination) + 1)]

for y in range(1, len(destination) + 1):
    for x in range(1, len(source) + 1):
        if destination[y - 1] == source[x - 1]:
            dp[y][x] = dp[y - 1][x - 1] + 1
        else:
            dp[y][x] = max(dp[y - 1][x], dp[y][x - 1])

print(dp[y][x])
