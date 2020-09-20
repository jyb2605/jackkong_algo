import sys

friend, relationship = map(int, sys.stdin.readline().split())
map_ = [[500_001 for _ in range(friend)] for _ in range(friend)]

for _ in range(relationship):
    start, end = map(int, sys.stdin.readline().split())
    map_[start - 1][end - 1] = 1
    map_[end - 1][start - 1] = 1

for i in range(friend): map_[i][i] = 0

for i in range(friend):
    for y in range(friend):
        for x in range(friend):
            if y == i or x == i:
                continue
            map_[y][x] = min(map_[y][x], map_[y][i] + map_[i][x])

sum_ = [sum(map_[i]) for i in range(friend)]
min_sum = min(sum_)

for i in range(friend):
    if min_sum == sum_[i]:
        print(i + 1)
        break
