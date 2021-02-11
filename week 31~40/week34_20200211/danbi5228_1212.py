import sys

N = sys.stdin.readline().strip()
num_8 = int('0o'+N, 8)
print(bin(num_8)[2:])
