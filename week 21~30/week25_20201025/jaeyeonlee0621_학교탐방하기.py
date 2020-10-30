import sys
from queue import PriorityQueue


def find(parent, x):
    return x if parent[x] == x else find(parent, parent[x])


# 입력 받기
n, m = map(int, sys.stdin.readline().split())
up = PriorityQueue()
down = PriorityQueue()

for _ in range(m + 1):
    start, end, road = map(int, sys.stdin.readline().split())
    if start == 0 and end == 1:
        continue
    up.put((road * -1, start, end))
    down.put((road, start, end))


def kruskal_algorithm(stair):
    answer = 0
    parent = [i for i in range(n + 1)]

    while not stair.empty():
        road, start, end = stair.get()

        start_parent = find(parent, start)
        end_parent = find(parent, end)

        if start_parent != end_parent:
            if start_parent < end_parent:
                start_parent, end_parent = end_parent, start_parent
            parent[start_parent] = end_parent
            if road == 0:
                answer += 1

    return answer ** 2


print(kruskal_algorithm(down) - kruskal_algorithm(up))
