import sys

node, vertex = map(int, sys.stdin.readline().split())

map_ = [[] for _ in range(node + 1)]
visited = [0 for _ in range(node + 1)]

for _ in range(vertex):
    start, end = map(int, sys.stdin.readline().split())
    map_[start].append(end)
    map_[end].append(start)

answer = 0
queue = []

for i in range(1, node + 1):
    if not visited[i]:
        visited[i] = 1
        queue = map_[i]
        while queue:
            num = queue.pop(0)
            if not visited[num]:
                queue.extend(map_[num])
                visited[num] = 1
        answer += 1

print(answer)
