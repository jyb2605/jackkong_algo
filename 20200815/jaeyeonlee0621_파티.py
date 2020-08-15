import sys

n, m, goal = map(int, sys.stdin.readline().split())

default = 100_000_000
go = [[default for _ in range(n)] for _ in range(n)]
back = [[default for _ in range(n)] for _ in range(n)]

for _ in range(m):
    start, end, weight = map(int, sys.stdin.readline().split())
    go[start - 1][end - 1] = weight
    back[start - 1][end - 1] = weight

for i in range(n):
    for x in range(n):
        if x != i and goal != i:
            go[x][goal] = min(go[x][goal], go[x][i] + go[i][goal])

for i in range(n):
    for x in range(n):
        if x != i and goal != i:
            back[goal][x] = min(back[goal][x], back[goal][i] + back[i][x])

answer = 0
for i in range(n):
    if go[x][goal] != default and back[goal][x] != default:
        answer = max(answer, go[x][goal] + back[goal][x])

print(answer)
