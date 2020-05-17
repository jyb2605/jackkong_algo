'''
모든 경우의 수를 탐색해야한다
'''

import sys

sys.setrecursionlimit(100000)

count = 0


def dp(sum, target, numbers, idx):
    if idx >= len(numbers):
        if sum == target:
            global count
            count += 1
        return
    dp(sum + numbers[idx], target, numbers, idx + 1)
    dp(sum - numbers[idx], target, numbers, idx + 1)


def solution(numbers, target):
    dp(0, target, numbers, 0)
    return count
