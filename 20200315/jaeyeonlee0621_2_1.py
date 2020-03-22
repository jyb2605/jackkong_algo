'''
백준 6603
'''

import sys
from itertools import combinations

while True:
    n, *numbers = map(int, sys.stdin.readline().split())
    if n == 0: break
    for line in combinations(numbers, 6):
        print(' '.join(map(str, line)))
    print()
