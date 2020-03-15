'''
python3
'''

import sys

n, m, v = map(int, sys.stdin.readline().split())

stack = [v - 1]
adj = [[] for _ in range(n)]
visited = [0] * n

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    adj[s - 1].append(e - 1)
    adj[e - 1].append(s - 1)

for i in range(n):
    adj[i].sort()

print(v, end=' ')
visited[v - 1] = 1

while stack:
    top = stack[-1]
    is_all_visited = 1
    for i in range(len(adj[top])):
        if not visited[adj[top][i]]:
            stack.append(adj[top][i])
            visited[adj[top][i]] = 1
            is_all_visited = 0
            print(adj[top][i] + 1, end=' ')
            break
    if is_all_visited:
        stack.pop()

print()

queue = [v - 1]
visited = [0] * n

print(v, end=' ')
visited[v - 1] = 1

while queue:
    front = queue.pop(0)
    for i in range(len(adj[front])):
        if not visited[adj[front][i]]:
            queue.append(adj[front][i])
            visited[adj[front][i]] = 1
            print(adj[front][i] + 1, end=' ')
