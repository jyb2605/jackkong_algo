import sys

row, col = map(int, sys.stdin.readline().split())

box = [[] for _ in range(col)]
all_ = 0

for y in range(col):
    box[y] = list(map(int, sys.stdin.readline().split()))
    for x in range(row):
        if box[y][x] != 0: all_ += 1

day = 0
while all_ < row * col:
    day += 1
    change = []
    for y in range(col):
        for x in range(row):
            if box[y][x] == 1:
                visited = [[0 for _ in range(row)] for _ in range(col)]
                queue = [(y, x)]
                while queue:
                    y_, x_ = queue.pop(0)
                    if not visited[y_][x_]:
                        visited[y_][x_] = 1
                        if y_ - 1 >= 0:
                            if box[y_ - 1][x_] == 1: queue.append((y_ - 1, x_))
                            if box[y_ - 1][x_] == 0: change.append((y_ - 1, x_))
                        if y_ + 1 < col:
                            if box[y_ + 1][x_] == 1: queue.append((y_ + 1, x_))
                            if box[y_ + 1][x_] == 0: change.append((y_ + 1, x_))
                        if x_ - 1 >= 0:
                            if box[y_][x_ - 1] == 1: queue.append((y_, x_ - 1))
                            if box[y_][x_ - 1] == 0: change.append((y_, x_ - 1))
                        if x_ + 1 < row:
                            if box[y_][x_ + 1] == 1: queue.append((y_, x_ + 1))
                            if box[y_][x_ + 1] == 0: change.append((y_, x_ + 1))
    for y, x in change:
        if box[y][x] == 0:
            box[y][x] = 1
            all_ += 1

print(day)
