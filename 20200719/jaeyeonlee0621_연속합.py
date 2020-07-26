'''
LCS를 푸는 방법과 비슷
'''
# import sys
#
# n = int(sys.stdin.readline())
# map_ = list(map(int, sys.stdin.readline().split()))
#
# dp = [map_, [0 for _ in range(n)]]
# answer = max(dp[0])
#
# y = 1
# for next in range(1, n):
#     for index in range(n - next):
#         dp[y][index] = dp[y ^ 1][index] + map_[index + next]
#         answer = max(answer, dp[y][index])
#     dp[y ^ 1] = [0 for _ in range(n)]
#     y ^= 1
#
# print(answer)

import sys

n = int(sys.stdin.readline())
map_ = list(map(int, sys.stdin.readline().split()))

dp = [0 for _ in range(n)]
dp[0] = map_[0]

answer = dp[0]

for i in range(1, n):
    dp[i] = max(dp[i - 1] + map_[i], map_[i])
    answer = max(answer, dp[i])

print(answer)
