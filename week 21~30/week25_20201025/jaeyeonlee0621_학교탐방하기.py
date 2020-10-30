import sys


def find(parent, x):
    return x if parent[x] == x else find(parent, parent[x])


# 입력 받기
n, m = map(int, sys.stdin.readline().split())
up = []
down = []

zero = 0
for _ in range(m + 1):
    start, end, road = map(int, sys.stdin.readline().split())
    if start == 0:
        zero = road
        continue

    up.append((road * -1, start, end))
    up.append((road * -1, end, start))

    down.append((road, start, end))
    down.append((road, end, start))


def kruskal_algorithm(stair):
    parent = [i for i in range(n + 1)]

    roads = [n + 1 for _ in range(n + 1)]
    roads[0] = 0
    roads[1] = zero

    stair.sort()
    for road, start, end in stair:
        if road < 0:
            road *= -1

        if roads[end] != n + 1:
            continue

        start_parent = find(parent, start)
        end_parent = find(parent, end)

        if start_parent != end_parent:
            if start_parent < end_parent:
                start_parent, end_parent = end_parent, start_parent
            parent[start_parent] = end_parent
            roads[end] = road

    return (n - sum(roads)) ** 2


print(kruskal_algorithm(down) - kruskal_algorithm(up))
