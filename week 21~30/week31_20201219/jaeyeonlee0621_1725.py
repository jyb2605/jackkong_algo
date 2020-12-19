import sys

n = int(sys.stdin.readline().strip())
graph = [int(sys.stdin.readline().strip()) for _ in range(n)]

answer = 0
stack = []
for i in range(n):
    while stack and graph[stack[-1]] > graph[i]:
        index = stack.pop()
        width = i - stack[-1] - 1 if stack else i
        answer = max(width * graph[index], answer)
    stack.append(i)

while stack:
    index = stack.pop()
    width = n - stack[-1] - 1 if stack else n
    answer = max(width * graph[index], answer)

print(answer)
