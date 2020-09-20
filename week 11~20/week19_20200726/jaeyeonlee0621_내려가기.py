import sys

length = int(sys.stdin.readline())
map_ = [list(map(int, sys.stdin.readline().split())) for _ in range(length)]

max_dp = [[0 for _ in range(len(map_[0]))] for _ in range(2)]
max_dp[0] = map_[0]

min_dp = [[1000000 for _ in range(len(map_[0]))] for _ in range(2)]
min_dp[0] = map_[0]

index = 0

for y in range(length - 1):
    for x in range(len(map_[0])):
        max_dp[index ^ 1][x] = max(max_dp[index ^ 1][x], max_dp[index][x] + map_[y + 1][x])
        min_dp[index ^ 1][x] = min(min_dp[index ^ 1][x], min_dp[index][x] + map_[y + 1][x])
        if x - 1 >= 0:
            max_dp[index ^ 1][x - 1] = max(max_dp[index ^ 1][x - 1], max_dp[index][x] + map_[y + 1][x - 1])
            min_dp[index ^ 1][x - 1] = min(min_dp[index ^ 1][x - 1], min_dp[index][x] + map_[y + 1][x - 1])
        if x + 1 < len(map_[y]):
            max_dp[index ^ 1][x + 1] = max(max_dp[index ^ 1][x + 1], max_dp[index][x] + map_[y + 1][x + 1])
            min_dp[index ^ 1][x + 1] = min(min_dp[index ^ 1][x + 1], min_dp[index][x] + map_[y + 1][x + 1])

    max_dp[index] = [0 for _ in range(len(map_[0]))]
    min_dp[index] = [1000000 for _ in range(len(map_[0]))]

    index ^= 1

print(f'{max(max_dp[index])} {min(min_dp[index])}')
