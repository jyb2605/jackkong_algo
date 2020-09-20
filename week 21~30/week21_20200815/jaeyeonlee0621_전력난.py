import sys


def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]


while True:
    node, count = map(int, sys.stdin.readline().split())
    if node == 0 and count == 0:
        break

    parent = [i for i in range(node)]  # 나의 부모는 누구인가
    rank = [0 for i in range(node)]  # 가장 최상위 부모가 누구인가 (최상위 일수록 rank up)

    answer = []
    vertexes = []

    sum_ = 0
    for _ in range(count):
        start, end, weight = map(int, sys.stdin.readline().split())
        vertexes.append([weight, start, end])
        sum_ += weight

    vertexes.sort(key=lambda vertex: vertex[0])

    for weight, start, end in vertexes:
        start_root = find(start)
        end_root = find(end)

        if start_root != end_root:
            answer.append(weight)

            if rank[start_root] > rank[end_root]:
                parent[end_root] = start_root

            else:
                parent[start_root] = end_root
                if rank[start_root] == rank[end_root]:
                    rank[end_root] += 1

    print(sum_ - sum(answer))
