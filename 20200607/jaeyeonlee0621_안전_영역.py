'''
min, max 값을 찾아 각 height마다 안전 구역의 개수를 구한다
단 모두 같은 높이라 안전 영역이 1개 일 수 있다
모두 같은 높이라는 뜻은 min과 max가 같다는 듯이므로 해당 부분은 구분해준다
'''
import sys
from collections import deque

count = int(sys.stdin.readline())
max_ = -1
min_ = 999
map_ = []

for _ in range(count):
    map_.append(list(map(int, sys.stdin.readline().split())))

for i in range(count):
    max_ = max(max(map_[i]), max_)
    min_ = min(min(map_[i]), min_)

if max_ == min_:
    answer = 1
else:
    answer = 0
    for height in range(min_, max_ + 1):
        safe_area = 0
        visited = [[0 for _ in range(count)] for _ in range(count)]

        for i in range(count):
            for j in range(count):

                if map_[i][j] > height and visited[i][j] == 0:
                    safe_area += 1
                    queue = deque()
                    queue.append((i, j))

                    while queue:
                        x, y = queue.popleft()

                        if visited[x][y] == 0:
                            visited[x][y] = 1
                            if x - 1 >= 0 and map_[x - 1][y] > height and visited[x - 1][y] == 0:
                                queue.append((x - 1, y))
                            if x + 1 < count and map_[x + 1][y] > height and visited[x + 1][y] == 0:
                                queue.append((x + 1, y))
                            if y - 1 >= 0 and map_[x][y - 1] > height and visited[x][y - 1] == 0:
                                queue.append((x, y - 1))
                            if y + 1 < count and map_[x][y + 1] > height and visited[x][y + 1] == 0:
                                queue.append((x, y + 1))

        answer = max(answer, safe_area)

print(answer)
