import sys

cable, need = map(int, sys.stdin.readline().split())
cables = [0 for _ in range(cable)]

for i in range(cable):
    cables[i] = int(sys.stdin.readline())

max_ = 0
for c in cables: max_ = max(c + 1, max_)
min_ = 0

while min_ < max_ - 1:
    mid_ = (min_ + max_) // 2
    cable = 0
    for c in cables: cable += (c // mid_)
    if cable >= need: min_ = mid_
    else: max_ = mid_

print(min_)
