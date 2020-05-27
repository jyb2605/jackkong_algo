'''
백준 1018
'''

import sys

col, row = map(int, sys.stdin.readline().split())

chess = [[] for _ in range(col)]

for i in range(col):
    chess[i] = list(str(sys.stdin.readline().strip()))

color = ('B', 'W')
color_list = [[], []]
color_list[0] = [color[j % 2] for j in range(row)]
color_list[1] = [color[(j + 1) % 2] for j in range(row)]


def check_odd_color():
    result = row * col + 1
    for y in range(0, col - 7):
        for x in range(0, row - 7):
            count = 0
            for i in range(y, y + 8):
                for j in range(x, x + 8):
                    if chess[i][j] != color_list[(i % 2)][j]:
                        count += 1
            result = min(result, count)
    return result


def check_even_color():
    result = row * col + 1
    for y in range(0, col - 7):
        for x in range(0, row - 7):
            count = 0
            for i in range(y, y + 8):
                for j in range(x, x + 8):
                    if chess[i][j] != color_list[(i + 1) % 2][j]:
                        count += 1
            result = min(result, count)
    return result


print(min(check_even_color(), check_odd_color()))
