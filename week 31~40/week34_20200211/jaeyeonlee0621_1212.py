import sys

n = str(int(sys.stdin.readline()))
number = int(f'0o{n}', 8)
print(bin(number)[2:])
