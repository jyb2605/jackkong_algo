import sys
from heapq import heappop, heappush

INF = 1e9


def dijkstra(start, n, map_):
    destination = [INF for _ in range(n)]
    destination[start] = 0

    queue = []
    heappush(queue, [0, start])

    while queue:
        weight, now = heappop(queue)
        for y, cost in map_[now]:
            if cost + weight < destination[y]:
                destination[y] = cost + weight
                heappush(queue, [cost + weight, y])

    return destination


n, m, goal = map(int, sys.stdin.readline().split())
map_ = [[] for _ in range(n)]

for _ in range(m):
    start, end, weight = map(int, sys.stdin.readline().split())
    map_[start - 1].append([end - 1, weight])

answer = [0 for _ in range(n)]
for i in range(n):
    destination = dijkstra(i, n, map_)
    if i == goal - 1:
        for i in range(n):
            answer[i] += destination[i]
    else:
        answer[i] += destination[goal - 1]

print(max(answer))

# for i in range(n):
#     for x in range(n):
#         for y in range(n):
#             if x != y:
#                 map_[x][y] = min(map_[x][y], map_[x][i] + map_[i][y])
#
# answer = 0
# for i in range(n):
#     if i != goal:
#         answer = max(answer, map_[i][goal] + map_[goal][i])
#
# print(answer)
