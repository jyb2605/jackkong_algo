'''
틀려씀ㅜㅜ
왜...
'''
import sys

number = list(map(int, sys.stdin.readline()[:-1]))

dp = [0 for _ in range(len(number) + 1)]
dp[-1] = 1

for i in range(len(number) - 1, -1, -1):
    if i + 1 < len(number) and 10 <= (number[i] * 10 + number[i + 1]) <= 26:
        dp[i] += dp[i + 2]
    if number[i] != 0:
        dp[i] += dp[i + 1]
    dp[i] %= 1000000

print(dp[0])
