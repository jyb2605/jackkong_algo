import sys

n = int(sys.stdin.readline())
list_ = list(map(int, sys.stdin.readline().split()))
stack = [list_[0], ]

for i in range(1, n):
    if stack[-1] < list_[i]:
        stack.append(list_[i])
    else:
        start = 0
        end = len(stack)
        # 작거나 같은 수 중에 최댓값
        while start < end:
            mid = (start + end) // 2
            if stack[mid] >= list_[i]: end = mid
            else: start = mid + 1
        stack[end] = list_[i]

print(len(stack))
