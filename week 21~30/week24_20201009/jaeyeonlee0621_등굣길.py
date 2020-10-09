# 최단 경로 순열

def solution(m, n, puddles):
    map = [[1 for _ in range(m)] for _ in range(n)]
    map[n - 1][m - 1] = -1

    for start, end in puddles:
        map[end - 1][start - 1] = 0

    for y in range(1, n):
        for x in range(1, m):
            if map[y][x] == 0:
                continue
            map[y][x] = (map[y - 1][x] + map[y][x - 1]) % 1000000007

    return 0 if map[n - 1][m - 1] == -1 else map[n - 1][m - 1]


print(solution(4, 3, [[2, 2]]))
print(solution(4, 3, [[1, 3], [3, 1]]))
