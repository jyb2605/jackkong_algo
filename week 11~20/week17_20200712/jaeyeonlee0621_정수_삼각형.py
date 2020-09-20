import sys

n = int(sys.stdin.readline())

map_ = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

if len(map_) == 1:
    print(map_[0][0])

else:
    for height in range(n - 1, 0, -1):
        for width in range(height):
            map_[height - 1][width] += max(map_[height][width], map_[height][width + 1])

print(map_[0][0])
