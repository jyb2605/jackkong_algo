import sys

n = int(sys.stdin.readline().strip())

dot = ['***', '* *', '***']
value = 3

while value < n:
    result = []
    for y in range(3):
        if y != 1:
            for i in range(len(dot)):
                result.append(f'{dot[i]}{dot[i]}{dot[i]}')
        else:
            for i in range(len(dot)):
                result.append(f'{dot[i]}{" " * value}{dot[i]}')
    dot = result
    value *= 3

print('\n'.join(dot))
