# https://www.acmicpc.net/problem/1013
import sys
import re

n = int(sys.stdin.readline().strip())

for _ in range(n):
    wave = str(sys.stdin.readline().strip())
    print('NO') if re.match(r"^(100+1+|01)+$", wave) is None else print('YES')
