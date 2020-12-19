import sys
from collections import deque

n = int(sys.stdin.readline().strip())

map_ = [sys.stdin.readline()[:-1] for _ in range(n)]
start, k = [], 0
for y in range(n):
    for x in range(n):
        if map_[y][x] == 'P':
            start = [y, x]
        if map_[y][x] == 'K':
            k += 1

tired = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

tired_range = []
for i in range(n):
    tired_range.extend(tired[i])
tired_range = sorted(list(set(tired_range)))


def bfs(left, right):
    visited = [[0 for _ in range(n)] for _ in range(n)]
    visited[start[0]][start[1]] = 1

    k_ = 0
    d = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

    queue = deque()
    queue.append(start)
    while queue:
        now = queue.popleft()
        y, x = now[0], now[1]

        for dy, dx in d:
            y_, x_ = y + dy, x + dx
            if not (0 <= y_ < n and 0 <= x_ < n):
                continue
            if visited[y_][x_] == 1:
                continue
            if not (tired_range[left] <= tired[y_][x_] <= tired_range[right]):
                continue
            visited[y_][x_] = 1
            if map_[y_][x_] == 'K':
                k_ += 1
            if k_ == k:
                return True
            queue.append([y_, x_])

    return False


answer, left = 10_000_000_000, 0
for right in range(len(tired_range)):
    while True:
        if not bfs(left, right):
            break
        answer = min(answer, tired_range[right] - tired_range[left])
        left += 1

print(answer)
