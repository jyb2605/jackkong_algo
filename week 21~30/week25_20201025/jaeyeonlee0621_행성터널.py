import sys
from queue import PriorityQueue

n = int(sys.stdin.readline())
planet = []

for i in range(n):
    x, y, z = map(int, sys.stdin.readline().split())
    planet.append((i, x, y, z))

queue = PriorityQueue()


def insert_queue(planet):
    for i in range(n - 1):
        weight = min(abs(planet[i][1] - planet[i + 1][1]), abs(planet[i][2] - planet[i + 1][2]),
                     abs(planet[i][3] - planet[i + 1][3]))
        queue.put((weight, planet[i][0], planet[i + 1][0]))


# x로 정렬
planet.sort(key=lambda x: x[1])
insert_queue(planet)

# y로 정렬
planet.sort(key=lambda x: x[2])
insert_queue(planet)

# z로 정렬
planet.sort(key=lambda x: x[3])
insert_queue(planet)


def find(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find(parent, parent[x])
    return parent[x]


answer = 0
parent = [i for i in range(n + 1)]

while not queue.empty():
    weight, start, end = queue.get()
    start_parent = find(parent, start)
    end_parent = find(parent, end)

    if start_parent != end_parent:
        if start_parent < end_parent:
            start_parent, end_parent = end_parent, start_parent
        parent[start_parent] = end_parent
        answer += weight

print(answer)
