'''
틀려씀ㅜㅜ
'''
import sys

number = list(map(int, sys.stdin.readline()[:-1]))

dp = [0 for _ in range(len(number) + 1)]
dp[-1] = 1

for i in range(len(number) - 1, -1, -1):
    if number[i] == 0:
        continue
    if i + 1 < len(number) and 1 <= (number[i] * 10 + number[i + 1]) <= 26:
        dp[i] = (dp[i + 1] + dp[i + 2]) % 1000000
    else:
        dp[i] = dp[i + 1]

print(dp[0])
