# https://www.acmicpc.net/problem/4792
import sys
from queue import PriorityQueue

while True:
    n, m, k = map(int, sys.stdin.readline().split())
    if n == m == k == 0:
        break

    graph = [[] for _ in range(n)]
    visited = [0 for _ in range(n)]

    for _ in range(m):
        color, start, end = map(int, sys.stdin.readline().split())
        graph[start].append((color, end))
        graph[end].append((color, start))

    for i in range(n):
        answer = 0

        queue = PriorityQueue()
        for node, color in graph[i]:
            queue.put((color, i, node))

        visited = [[] for _ in range(n)]
        visited[i] = 1
        while queue:
            count = 0
            for i in range(n):
                count += len(visited[i])
            if count / 2 == k:

            if len(visited) - 1 == k:
                answer = 1
                break

            node1, node2 = queue.popleft()
            if visited[node2]:
                continue

            if find(node1) == find(node2):
                continue

            union(node1, node2)
            visited[node2] = 1
            for j in graph[node2]:
                queue.append((node2, j))

        print(answer)
