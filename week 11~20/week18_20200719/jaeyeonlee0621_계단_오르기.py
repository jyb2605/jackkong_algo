import sys

n = int(sys.stdin.readline())
stairs = [int(sys.stdin.readline()) for _ in range(n)]
dp = [[0 for _ in range(n + 3)] for _ in range(2)]
dp[0][n - 1] = stairs[n - 1]
dp[1][n - 1] = stairs[n - 1]

for index in range(n - 2, -1, -1):
    if index == n - 3:
        dp[0][index] = dp[1][index + 1]
        dp[1][index] = dp[1][index + 2] + stairs[index]
    else:
        dp[0][index] = dp[1][index + 1]
        dp[1][index] = stairs[index] + max(stairs[index + 1] + dp[0][index + 2], dp[1][index + 2])

print(max(dp[0][0], dp[1][0]))
