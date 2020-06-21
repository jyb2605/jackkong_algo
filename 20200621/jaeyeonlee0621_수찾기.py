import sys

n = int(sys.stdin.readline())
bases = list(map(str, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
find = list(map(str, sys.stdin.readline().split()))

map_ = {}

for i in range(n):
    if not map_.get(str(bases[i])):
        map_[str(bases[i])] = 1

for i in range(m):
    if map_.get(find[i]):
        print(1)
    else:
        print(0)
