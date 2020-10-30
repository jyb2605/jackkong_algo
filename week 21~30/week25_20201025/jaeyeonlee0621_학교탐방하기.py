import sys
from queue import PriorityQueue


def find(parent, x):
    return x if parent[x] == x else find(parent, parent[x])


# 입력 받기
n, m = map(int, sys.stdin.readline().split())
nodes = [[] for _ in range(n + 1)]

zero = 0
for _ in range(m + 1):
    start, end, road = map(int, sys.stdin.readline().split())
    if start == 0:
        zero = road
    else:
        nodes[start].append((end, road))
        nodes[end].append((start, road))


def kruskal_algorithm(status):
    parent = [i for i in range(n + 1)]

    roads = [n + 1 for _ in range(n + 1)]
    roads[0] = 0
    roads[1] = zero

    queue = PriorityQueue()
    for end, road in nodes[1]:
        if status == 1:
            road *= -1
        queue.put((road * -1, 1, end))

    while not queue.empty():
        road, start, end = queue.get()

        if status == 1:
            road *= -1

        start_parent = find(parent, start)
        end_parent = find(parent, end)

        if start_parent != end_parent:
            if start_parent < end_parent:
                start_parent, end_parent = end_parent, start_parent
            parent[start_parent] = end_parent
            roads[end] = road

            start = end
            for end, road in nodes[start]:
                if status == 1:
                    road *= -1
                queue.put((road, start, end))

    return (n - sum(roads)) ** 2


print(kruskal_algorithm(0) - kruskal_algorithm(1))
