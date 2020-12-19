import sys

n = int(sys.stdin.readline().strip())
graph = [int(sys.stdin.readline().strip()) for _ in range(n)]

answer = 0
for i in range(n):
    now, width = graph[i], graph[i]
    left, right = i - 1, i + 1

    while left >= 0:
        if graph[left] < now:
            break
        width += now
        left -= 1

    while right < n:
        if graph[right] < now:
            break
        width += now
        right += 1

    answer = max(answer, width)

print(answer)
