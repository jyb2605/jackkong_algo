from collections import deque


def solution(m, n, puddles):
    map = [[m * n for _ in range(m)] for _ in range(n)]

    map[0][0] = 0
    for start, end in puddles:
        map[start - 1][end - 1] = -1

    queue = deque([])
    queue.append((0, 0, 0))

    while queue:
        start, end, value = queue.popleft()
        if end + 1 < m and map[start][end + 1] != -1:
            map[start][end + 1] = min(map[start][end], value)
            queue.append((start, end + 1, value + 1))
        if start + 1 < n and map[start + 1][end] != -1:
            queue.append((start + 1, end, value + 1))
        map[start][end] = min(map[start][end], value)
    return map[-1][-1]


print(solution(4, 3, [[2, 2]]))
