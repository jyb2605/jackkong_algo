# https://www.acmicpc.net/problem/4792
import sys

from queue import PriorityQueue


def find(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find(parent, parent[x])
    return parent[x]


def kruskal_algorithm(color):
    answer = 0
    parent = [i for i in range(n + 1)]

    nodes = blue if color == 'B' else red
    color_status = 0 if color == 'B' else 1

    while not nodes.empty():
        color, start, end = nodes.get()

        start_parent = find(parent, start)
        end_parent = find(parent, end)

        if start_parent != end_parent:
            if start_parent < end_parent:
                start_parent, end_parent = end_parent, start_parent
            parent[start_parent] = end_parent
            if color_status == color:
                answer += 1

    return answer


while True:
    n, m, k = map(int, sys.stdin.readline().split())
    if n == m == k == 0:
        break

    red = PriorityQueue()
    blue = PriorityQueue()

    for _ in range(m):
        color, start, end = map(str, sys.stdin.readline().split())

        start, end = int(start), int(end)
        if color == 'B':
            red.put((1, start, end))
            blue.put((0, start, end))

        if color == 'R':
            red.put((0, start, end))
            blue.put((1, start, end))

    min_ = kruskal_algorithm('R')
    max_ = kruskal_algorithm('B')

    print(int(min_ <= k <= max_))
