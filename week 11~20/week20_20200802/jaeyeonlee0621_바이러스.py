import sys
import heapq

node = int(sys.stdin.readline())
edge = int(sys.stdin.readline())

edges = [[] for _ in range(node)]
visited = [0 for _ in range(node)]

for _ in range(edge):
    start, end = map(int, sys.stdin.readline().split())
    edges[start - 1].append(end - 1)
    edges[end - 1].append(start - 1)

heap = []
for i in edges[0]:
    heapq.heappush(heap, i)

while heap:
    index = heapq.heappop(heap)

    if visited[index] == 0:
        visited[index] = 1

        for i in edges[index]:
            if visited[i] == 0:
                heapq.heappush(heap, i)

answer = 0
for i in range(node):
    if visited[i] == 1:
        answer += 1
print(answer - 1)