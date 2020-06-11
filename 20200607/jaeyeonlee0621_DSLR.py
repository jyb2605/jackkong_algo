import sys
from collections import deque

count = int(sys.stdin.readline())

for _ in range(count):
    visited = [0 for _ in range(10002)]

    answer = 0

    start, target = map(int, sys.stdin.readline().split())
    queue = deque()
    queue.append((start, ''))

    while queue:
        index, status = queue.popleft()

        if index == target:
            answer = status
            break

        if visited[index] == 0:
            visited[index] = 1

            twice_index = (index * 2) % 10000
            if visited[twice_index] == 0:
                queue.append((twice_index, status + 'D'))

            minus_one_index = index - 1
            if minus_one_index <= 0:
                minus_one_index = 9999
            if visited[minus_one_index] == 0:
                queue.append((minus_one_index, status + 'S'))

            left_turn_index = (index % 1000) * 10 + (index // 1000)
            if visited[left_turn_index] == 0:
                queue.append((left_turn_index, status + 'L'))

            right_turn_index = (index % 10) * 1000 + index // 10
            if visited[right_turn_index] == 0:
                queue.append((right_turn_index, status + 'R'))

    print(answer)
