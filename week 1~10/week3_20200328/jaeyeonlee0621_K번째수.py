import itertools


def solution(numbers):
    return sorted(list(map(''.join, itertools.permutations(list(map(str, numbers)), len(numbers)))))[-1]


print(solution([6, 10, 2]))
print(solution([3, 30, 34, 5, 9]))
