import sys

sys.setrecursionlimit(100000)

length, multiple = map(int, sys.stdin.readline().split())
map_ = [list(map(int, sys.stdin.readline().split())) for _ in range(length)]


def _multiple(A, B):
    return [[sum(a * b for a, b in zip(A_row, B_col)) % 1000 for B_col in zip(*B)] for A_row in A]


def solution(_length):
    if _length == 1:
        return map_
    result = solution(_length // 2)
    result = _multiple(result, result)
    if _length % 2 == 1:
        result = _multiple(result, map_)
    return result


answer = solution(multiple)
for i in range(length):
    print(' '.join(map(str, [value % 1000 for value in answer[i]])))
