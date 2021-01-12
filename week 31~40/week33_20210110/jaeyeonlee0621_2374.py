import sys

n = int(sys.stdin.readline())
queue = [int(sys.stdin.readline()) for _ in range(n)]

answer = 0

while len(queue) > 1:
    unique_set = set()
    queue = [x for x in queue if not (x in unique_set or unique_set.add(x))]

    for i in range(len(queue)):
        if i == 0 and i + 1 < len(queue) and queue[i] < queue[i + 1]:
            answer += queue[i + 1] - queue[i]
            queue[i] = queue[i + 1]
        if i == len(queue) - 1 and i - 1 >= 0 and queue[i - 1] > queue[i]:
            answer += queue[i - 1] - queue[i]
            queue[i] = queue[i - 1]
        if i - 1 >= 0 and i + 1 < len(queue) and queue[i - 1] > queue[i] < queue[i + 1]:
            min_queue = min(queue[i - 1], queue[i + 1])
            answer += min_queue - queue[i]
            queue[i] = min_queue

print(answer)
