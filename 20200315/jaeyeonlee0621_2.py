'''
백준 6603
'''

import sys


def dp(numbers: list, n: int, cur: int, lotto: list):
    if len(lotto) == 6:
        for idx in range(6):
            print(lotto[idx], end=' ')
        print()
    for idx in range(cur, n):
        lotto.append(numbers[idx])
        dp(numbers, n, idx + 1, lotto)
        lotto.pop()


while True:
    n, *numbers = map(int, sys.stdin.readline().strip().split())
    if n == 0: break
    print()
    dp(numbers, n, 0, [])
