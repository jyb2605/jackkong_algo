'''
백준 7576
queue 는 collections의 deque를 이용해야 시간초과를 해결할 수 있다
'''
import sys

from collections import deque

row, col = map(int, sys.stdin.readline().split())

box = [[] for _ in range(col)]
queue = deque()
all_ = 0

for y in range(col):
    box[y] = list(map(int, sys.stdin.readline().split()))
    for x in range(row):
        if box[y][x] != 0: all_ += 1
        if box[y][x] == 1: queue.append((y, x, 0))

day_ = 0
while queue:
    y_, x_, day = queue.popleft()
    day_ = max(day_, day)
    if y_ - 1 >= 0 and box[y_ - 1][x_] == 0:
        all_ += 1
        box[y_ - 1][x_] = 1
        queue.append((y_ - 1, x_, day + 1))
    if y_ + 1 < col and box[y_ + 1][x_] == 0:
        all_ += 1
        box[y_ + 1][x_] = 1
        queue.append((y_ + 1, x_, day + 1))
    if x_ - 1 >= 0 and box[y_][x_ - 1] == 0:
        all_ += 1
        box[y_][x_ - 1] = 1
        queue.append((y_, x_ - 1, day + 1))
    if x_ + 1 < row and box[y_][x_ + 1] == 0:
        all_ += 1
        box[y_][x_ + 1] = 1
        queue.append((y_, x_ + 1, day + 1))

if all_ == row * col:
    print(day_)
else:
    print(-1)
