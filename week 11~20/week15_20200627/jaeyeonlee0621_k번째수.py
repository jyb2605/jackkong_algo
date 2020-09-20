import sys

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())

start = 1
end = k

while start <= end:
    mid_ = (start + end) // 2
    num = 0
    for i in range(1, n + 1):
        num += min(mid_ // i, n)
    if num < k:
        start = mid_ + 1
    else:
        end = mid_ - 1

print(start)
