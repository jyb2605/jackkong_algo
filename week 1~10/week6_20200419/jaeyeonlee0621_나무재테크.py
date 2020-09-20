'''
봄
- 자신의 나이만큼 양분을 먹고 나이가 1씩 증가
- 나무는 자신이 있는 곳의 양분만 먹을 수 있음
- 여러개의 나무가 있다면 나이가 어린 나무부터 양분을 먹음
- 양분을 먹을 수 없다면 죽음

여름
- 봄에 죽은 나무가 양분으로 변함
- 죽은 나무는 나이로 2로 나눈값이 양분으로 추가 > 소수점 아래는 버린다

가을
- 나무가 번식
- 번식하는 나무는 나이가 5의 배수여야 한다
- 인접한 8개의 칸에 나이가 1인 나무가 생긴다

겨울
- 양분을 추가해줌
- 양분이 추가되는 양은 입력으로 주어짐
'''

import sys

answer = 0

n, m, k = map(int, sys.stdin.readline().split())
land = [[5 for _ in range(102)] for _ in range(102)]
nourishment = []
tree = [[[] for _ in range(102)] for _ in range(102)]
dead_tree = []

for x in range(n): nourishment.append(list(map(int, sys.stdin.readline().split())))

for _ in range(m):
    x, y, year = map(int, sys.stdin.readline().split())
    tree[x - 1][y - 1].append(year)

for x in range(n):
    for y in range(n):
        if tree[x][y]: tree[x][y].sort(reverse=True)

for _ in range(k):

    # 봄
    for x in range(n):
        for y in range(n):
            for index in range(len(tree[x][y])-1, -1, -1):
                if land[x][y] < tree[x][y][index]:
                    for i in range(index, -1, -1): land[x][y] += int(tree[x][y][i] / 2)
                    tree[x][y] = tree[x][y][index + 1:]
                    break
                land[x][y] -= tree[x][y][index]
                tree[x][y][index] += 1

    # 가을
    for x in range(n):
        for y in range(n):
            for i in range(len(tree[x][y])):
                if tree[x][y][i] % 5 == 0:
                    if x - 1 >= 0 and y - 1 >= 0: tree[x - 1][y - 1].append(1)
                    if x - 1 >= 0: tree[x - 1][y].append(1)
                    if x - 1 >= 0 and y + 1 < n: tree[x - 1][y + 1].append(1)
                    if y - 1 >= 0: tree[x][y - 1].append(1)
                    if y + 1 < n: tree[x][y + 1].append(1)
                    if x + 1 < n and y - 1 >= 0: tree[x + 1][y - 1].append(1)
                    if x + 1 < n: tree[x + 1][y].append(1)
                    if x + 1 < n and y + 1 < n: tree[x + 1][y + 1].append(1)

    # 겨울
    for x in range(n):
        for y in range(n): land[x][y] += nourishment[x][y]

for x in range(n):
    for y in range(n): answer += len(tree[x][y])

print(answer)
