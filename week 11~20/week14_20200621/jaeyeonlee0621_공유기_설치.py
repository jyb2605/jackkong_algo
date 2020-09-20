'''
2110번 공유기 설치
'''

import sys

home, router = map(int, sys.stdin.readline().split())
homes = [0 for _ in range(home)]

for i in range(home):
    homes[i] = int(sys.stdin.readline())
homes.sort()

max_ = homes[-1] - homes[0]
min_ = 1

while min_ < max_ - 1:
    mid_ = (min_ + max_) // 2
    install = 1
    now = homes[0]
    for i in range(1, home):
        if homes[i] - now >= mid_:
            now = homes[i]
            install += 1
    if install >= router:
        min_ = mid_
    else:
        max_ = mid_

print(min_)
