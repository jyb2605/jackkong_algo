import sys
N = int(input())
arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))
start, end = 0, N-1
result = [0, 0]
tmp = 3000000000
while start < end:
    sum_ = abs(arr[start] + arr[end])
    if sum_ < tmp:
        result[0] = arr[start]
        result[1] = arr[end]
        tmp = sum_
    else:
        if abs(arr[start]) > abs(arr[end]):
            start += 1
        else:
            end -= 1
print(result[0], result[1])