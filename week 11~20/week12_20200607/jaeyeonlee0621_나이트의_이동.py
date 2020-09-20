import sys
from collections import deque

count = int(sys.stdin.readline())

for _ in range(count):
    map_count = int(sys.stdin.readline())
    visited = [[0 for _ in range(map_count)] for _ in range(map_count)]

    start = list(map(int, sys.stdin.readline().split()))
    goal = list(map(int, sys.stdin.readline().split()))

    queue = deque()
    queue.append((start[0], start[1], 0))
    while queue:
        y, x, order = queue.popleft()
        if y == goal[0] and x == goal[1]:
            print(order)
            break
        if visited[y][x] == 0:
            order += 1
            visited[y][x] = 1
            if y + 1 < map_count and x - 2 >= 0 and visited[y + 1][x - 2] == 0:
                queue.append((y + 1, x - 2, order))
            if y + 1 < map_count and x + 2 < map_count and visited[y + 1][x + 2] == 0:
                queue.append((y + 1, x + 2, order))
            if y - 1 >= 0 and x - 2 >= 0 and visited[y - 1][x - 2] == 0:
                queue.append((y - 1, x - 2, order))
            if y - 1 >= 0 and x + 2 < map_count and visited[y - 1][x + 2] == 0:
                queue.append((y - 1, x + 2, order))
            if x + 1 < map_count and y - 2 >= 0 and visited[y - 2][x + 1] == 0:
                queue.append((y - 2, x + 1, order))
            if x + 1 < map_count and y + 2 < map_count and visited[y + 2][x + 1] == 0:
                queue.append((y + 2, x + 1, order))
            if x - 1 >= 0 and y - 2 >= 0 and visited[y - 2][x - 1] == 0:
                queue.append((y - 2, x - 1, order))
            if x - 1 >= 0 and y + 2 < map_count and visited[y + 2][x - 1] == 0:
                queue.append((y + 2, x - 1, order))
