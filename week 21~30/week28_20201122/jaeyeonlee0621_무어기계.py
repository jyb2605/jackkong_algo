# https://www.acmicpc.net/problem/2671
import sys
import re
from string import ascii_uppercase

n = int(sys.stdin.readline().strip())

for _ in range(n):
    pattern = str(sys.stdin.readline().strip()).upper()
    word = str(sys.stdin.readline().strip()).upper()

    match_count, match_alpha = 0, ''
    for alpha in list(ascii_uppercase):
        replaced_pattern = pattern.replace('_', alpha)

        if re.match(f'^{replaced_pattern}$', word) is not None:
            match_count += 1
            match_alpha = alpha

    if match_count > 1:
        print('_')
    if match_count == 1:
        print(match_alpha)
    if match_count == 0:
        print('!')
