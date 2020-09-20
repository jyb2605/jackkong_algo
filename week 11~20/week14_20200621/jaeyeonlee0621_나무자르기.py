'''
2005번
'''

import sys

tree, need = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

max_ = 0
for t in trees: max_ = max(max_, t)
min_ = 0

# while min_ < max_ - 1:
#     mid_ = (min_ + max_) // 2
#     remain = 0
#     for t in trees:
#         if t > mid_: remain += (t - mid_)
#         if remain >= need: break
#     if remain >= need:
#         min_ = mid_
#     else:
#         max_ = mid_
#
# print(min_)

while min_ <= max_:
    mid_ = (min_ + max_) // 2
    remain = 0
    for t in trees:
        if t > mid_: remain += (t - mid_)
        if remain >= need: break
    if remain >= need: min_ = mid_ + 1
    else: max_ = mid_ - 1

print(max_)
