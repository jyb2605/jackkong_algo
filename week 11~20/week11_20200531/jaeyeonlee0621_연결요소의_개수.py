'''
백준 11724
BFS보다 DFS가 더 시간이 빠르다
BFS는 모든 node를 방문하고 DFS는 일정 node는 방문하지 않기 때문이다
'''

import sys

node, vertex = map(int, sys.stdin.readline().split())

map_ = [[] for _ in range(node + 1)]
visited = [0 for _ in range(node + 1)]

for _ in range(vertex):
    start, end = map(int, sys.stdin.readline().split())
    map_[start].append(end)
    map_[end].append(start)

# BFS
# answer = 0
# queue = []
#
# for i in range(1, node + 1):
#     if not visited[i]:
#         visited[i] = 1
#         queue = map_[i]
#         while queue:
#             num = queue.pop(0)
#             if not visited[num]:
#                 queue.extend(map_[num])
#                 visited[num] = 1
#         answer += 1
#
# print(answer)


answer = 0
stack = []

for i in range(1, node + 1):
    if not visited[i]:
        visited[i] = 1
        stack = map_[i]
        while stack:
            num = stack.pop()
            if not visited[num]:
                stack.extend(map_[num])
                visited[num] = 1
        answer += 1

print(answer)
