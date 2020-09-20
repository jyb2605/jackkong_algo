'''
백준 1697
'''

import sys
from collections import deque

start, target = map(int, sys.stdin.readline().split())

queue = deque()
queue.append((start, 0))
visited = [0 for _ in range(100001)]

while queue:
    now, time = queue.popleft()
    if now == target:
        print(time)
        break
    visited[now] = 1
    if now - 1 >= 0 and not visited[now - 1]: queue.append((now - 1, time + 1))
    if now + 1 <= 100000 and not visited[now + 1]: queue.append((now + 1, time + 1))
    if now * 2 <= 100000 and not visited[now * 2]: queue.append((now * 2, time + 1))
