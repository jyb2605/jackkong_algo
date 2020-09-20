import sys

gear = []
for _ in range(4): gear.append(sys.stdin.readline()[:-1])
k = int(sys.stdin.readline())
now = [0, 0, 0, 0]


def change_index(index, add):
    return (index + 8 + add) % 8


for _ in range(k):
    gear_num, rotate_ = map(int, sys.stdin.readline().split())
    gear_num -= 1
    rotate = [0, 0, 0, 0]
    rotate[gear_num] = rotate_
    for index in range(gear_num, 0, -1):
        if gear[index - 1][change_index(now[index - 1], 2)] != gear[index][change_index(now[index], -2)]:
            if rotate[index] == -1: rotate[index - 1] = 1
            if rotate[index] == 1: rotate[index - 1] = -1
    for index in range(gear_num, 3):
        if gear[index][change_index(now[index], 2)] != gear[index + 1][change_index(now[index + 1], -2)]:
            if rotate[index] == -1: rotate[index + 1] = 1
            if rotate[index] == 1: rotate[index + 1] = -1
    for i in range(4):
        if rotate[i] == 1: now[i] = change_index(now[i], -1)
        if rotate[i] == -1: now[i] = change_index(now[i], 1)

answer = 0
score = 1
for i in range(4):
    if gear[i][now[i]] == '1': answer += (score << i)

print(answer)