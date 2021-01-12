import sys

answer = 0

n = int(sys.stdin.readline())
queue = []

for i in range(n):
    num = int(sys.stdin.readline())

    if not queue or queue[-1] > num:
        queue.append(num)
        continue

    answer += num - queue[-1]
    while queue and queue[-1] < num:
        queue.pop()

    queue.append(num)

answer += queue[0] - queue[-1]
print(answer)
