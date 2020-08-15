import sys

n, m, goal = map(int, sys.stdin.readline().split())
goal = goal - 1

default = 100_000_000
map_ = [[default for _ in range(n)] for _ in range(n)]

for _ in range(m):
    start, end, weight = map(int, sys.stdin.readline().split())
    map_[start - 1][end - 1] = weight

for i in range(n):
    for x in range(n):
        for y in range(n):
            if x != y:
                map_[x][y] = min(map_[x][y], map_[x][i] + map_[i][y])

answer = 0
for i in range(n):
    if i != goal:
        answer = max(answer, map_[i][goal] + map_[goal][i])

print(answer)
