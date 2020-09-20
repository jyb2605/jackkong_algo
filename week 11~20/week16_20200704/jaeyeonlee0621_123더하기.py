import sys

n = int(sys.stdin.readline())

map_ = [0 for _ in range(13)]
map_[1] = 1
map_[2] = 2
map_[3] = 4

for k in range(4, 12):
    map_[k] = map_[k - 1] + map_[k - 2] + map_[k - 3]

for i in range(n):
    j = int(sys.stdin.readline())
    print(map_[j])
