'''
백준 10026
'''
import sys


def check_section(map_, n):
    visited = [[0 for _ in range(n)] for _ in range(n)]
    queue = []
    result = 0

    for col in range(0, n):
        for row in range(0, n):
            if not visited[col][row]:
                queue.append((col, row))
                visited[col][row] = 1
                color = map_[col][row]
                while len(queue):
                    x, y = queue.pop(0)
                    if x > 0 and not visited[x - 1][y] and map_[x - 1][y] == color:
                        queue.append((x - 1, y))
                        visited[x - 1][y] = 1
                    if y > 0 and not visited[x][y - 1] and map_[x][y - 1] == color:
                        queue.append((x, y - 1))
                        visited[x][y - 1] = 1
                    if x < n - 1 and not visited[x + 1][y] and map_[x + 1][y] == color:
                        queue.append((x + 1, y))
                        visited[x + 1][y] = 1
                    if y < n - 1 and not visited[x][y + 1] and map_[x][y + 1] == color:
                        queue.append((x, y + 1))
                        visited[x][y + 1] = 1
                result += 1

    print(result)


n = int(sys.stdin.readline())
map_ = [[] for _ in range(n)]

for col in range(0, n):
    map_[col] = list(str(sys.stdin.readline().strip()))

check_section(map_, n)

for col in range(0, n):
    for row in range(0, n):
        if map_[col][row] == 'G': map_[col][row] = 'R'

check_section(map_, n)
