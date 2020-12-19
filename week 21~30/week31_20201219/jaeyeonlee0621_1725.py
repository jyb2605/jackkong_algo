import sys

n = int(sys.stdin.readline().strip())
graph = [int(sys.stdin.readline().strip()) for _ in range(n)]

answer, min_width = 0, 2000000000
stack = []
for i in range(n):
    min_width = min(min_width, graph[i])
    while stack and stack[-1][1] > graph[i]:
        index, width = stack.pop()
        answer = max((i - index) * width, answer)
    stack.append((i, graph[i]))

while stack:
    index, width = stack.pop()
    answer = max((n - index) * width, answer)

answer = max(answer, min_width * n)
print(answer)
