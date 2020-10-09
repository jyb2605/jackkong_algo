from collections import deque


def solution(n, edge):
    MAX = 50001

    visited = [0 for _ in range(n)]
    weight = [MAX for _ in range(n)]

    map = [[] for _ in range(n)]
    for start, end in edge:
        map[start - 1].append(end - 1)
        map[end - 1].append(start - 1)

    visited[0] = 1
    weight[0] = 0

    queue = deque([])
    for node in map[0]:
        queue.append(node)

    while queue:
        node = queue.popleft()
        if visited[node] == 1:
            continue
        visited[node] = 1
        value = MAX
        for neighbor in map[node]:
            value = min(value, weight[neighbor] + 1)
        weight[node] = value
        for node in map[node]:
            queue.append(node)

    max_value = max(weight)
    answer = 0
    for w in weight:
        if max_value == w:
            answer += 1

    return answer


print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))
