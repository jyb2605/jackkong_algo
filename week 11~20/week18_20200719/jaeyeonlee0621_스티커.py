import sys

n = int(sys.stdin.readline())
for _ in range(n):
    m = int(sys.stdin.readline())

    sticker = []
    for _ in range(2):
        sticker.append(list(map(int, sys.stdin.readline().split())))

    dp = [[0 for _ in range(m + 3)], [0 for _ in range(m + 3)]]

    for x in range(m - 1, -1, -1):
        for y in range(2):
            if y == 0:
                dp[y][x] = sticker[y][x] + max(dp[1][x + 1], dp[1][x + 2])
            else:
                dp[y][x] = sticker[y][x] + max(dp[0][x + 1], dp[0][x + 2])

    print(max(dp[0][0], dp[1][0]))
