# https://programmers.co.kr/learn/courses/30/lessons/43105

def solution(triangle):
    for h in range(1, len(triangle)):
        for c in range(len(triangle[h])):
            if c == 0:
                triangle[h][c] += triangle[h - 1][c]
                continue
            if c == len(triangle[h]) - 1:
                triangle[h][c] += triangle[h - 1][c - 1]
                continue
            triangle[h][c] += max(triangle[h - 1][c - 1], triangle[h - 1][c])
    return max(triangle[-1])


print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))
