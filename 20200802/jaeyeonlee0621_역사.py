import sys

event, history = map(int, sys.stdin.readline().split())

map_ = [[0 for _ in range(event)] for _ in range(event)]

for _ in range(history):
    start, end = map(int, sys.stdin.readline().split())
    map_[start - 1][end - 1] = -1
    map_[end - 1][start - 1] = 1

for i in range(event):
    for y in range(event):
        for x in range(event):
            if map_[y][i] == -1 and map_[i][x] == -1:
                map_[x][y] = 1
                map_[y][x] = -1

count = int(sys.stdin.readline())

for _ in range(count):
    start, end = map(int, sys.stdin.readline().split())
    print(map_[start - 1][end - 1])
