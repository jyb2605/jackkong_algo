# 최단 경로 순열
# https://programmers.co.kr/learn/courses/30/lessons/42898

def solution(m, n, puddles):
    map = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

    for start, end in puddles:
        map[end][start] = -1

    map[1][1] = 1
    for y in range(1, n + 1):
        for x in range(1, m + 1):
            if x == y == 1:
                continue
            if map[y][x] == -1:
                map[y][x] = 0
                continue
            map[y][x] = (map[y - 1][x] + map[y][x - 1]) % 1000000007

    return map[n][m]


# print(solution(4, 3, [[2, 2]]))
print(solution(4, 3, [[1, 3], [3, 1]]))
