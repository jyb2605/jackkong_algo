import sys
from queue import PriorityQueue

# 입력 받기
n, m = map(int, sys.stdin.readline().split())
up = PriorityQueue()
down = PriorityQueue()
zero = 0

for _ in range(m + 1):
    start, end, road = map(int, sys.stdin.readline().split())
    if start == 0 and end == 1:

        zero = road
        continue
    down.put((road * -1, start, end))
    up.put((road, start, end))
        continue
    up.put((road * -1, start, end))
    down.put((road, start, end))


def find(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find(parent, parent[x])
    return parent[x]


def kruskal_algorithm(stair):
    vertex = 0
    answer = 0
    parent = [i for i in range(n + 1)]

    while not stair.empty():
        road, start, end = stair.get()

        start_parent = find(parent, start)
        end_parent = find(parent, end)

        if start_parent != end_parent:
            vertex += 1
            if start_parent < end_parent:
                start_parent, end_parent = end_parent, start_parent
            parent[start_parent] = end_parent
            if road == 0:
                answer += 1

        # 시간 초과 해결 방법
        if vertex == n - 1:
            break

    if zero == 0:
        answer += 1

    return answer ** 2


print(kruskal_algorithm(up) - kruskal_algorithm(down))
    return answer ** 2


print(kruskal_algorithm(down) - kruskal_algorithm(up))
