# https://www.acmicpc.net/problem/2671
import sys
import re

wave = str(sys.stdin.readline().strip())
print('NOISE') if re.match(r"^(100+1+|01)+$", wave) is None else print('SUBMARINE')
