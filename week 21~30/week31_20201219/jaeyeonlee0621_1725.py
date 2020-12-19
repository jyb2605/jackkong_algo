import sys

n = int(sys.stdin.readline().strip())
graph = [int(sys.stdin.readline().strip()) for _ in range(n)]

answer = 0

stack = []
for i in range(n):
    while stack and stack[-1][1] > graph[i]:
        index, width = stack.pop()
        answer = max((i - index) * width, answer)
    stack.append((i, graph[i]))

index_ = stack[-1][0] + 1
while stack:
    index, width = stack.pop()
    answer = max((index_ - index) * width, answer)

print(answer)
