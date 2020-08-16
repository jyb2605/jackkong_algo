import sys
from heapq import heappop, heappush


def bfs(start, end, node, visited):
    visited_ = [[0 for _ in range(node)] for _ in range(node)]
    vertex = [0 for _ in range(node)]
    vertex[start] = 1

    queue = []
    heappush(queue, [start, end])

    while queue:
        start, end = heappop(queue)

        if vertex[end]:
            return True

        vertex[end] = 1
        visited_[start][end] = 1
        visited_[end][start] = 1

        for i in range(node):
            if visited[end][i] and not visited_[end][i]:
                heappush(queue, [end, i])

    return False


node, count = map(int, sys.stdin.readline().split())

visited = [[0 for _ in range(node)] for _ in range(node)]
answer = []
vertexes = []

for _ in range(count):
    start, end, weight = map(int, sys.stdin.readline().split())
    vertexes.append([weight, start - 1, end - 1])

vertexes.sort(key=lambda vertexes: vertexes[0])

for weight, start, end in vertexes:
    if not visited[start][end] and not bfs(start, end, node, visited):
        visited[start][end] = 1
        visited[end][start] = 1
        answer.append(weight)

print(sum(answer[:-1]))