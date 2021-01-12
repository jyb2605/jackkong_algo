"""
내가 못 풀었고 사람들꺼보고 남기는 후기
ex) 5 3 1 이 들어오면 answer = 5 - 1 = 4

즉 자기보다 낮은 것 순으로 stack에 남기는게 목표
ex) 5 1 3 이면 5 1 까지는 stack에 있는데 3 은 1보다 크니까 anwer += 3 - 1 을 해주고 pop 해준 이후 넣음 그러면 5 3 이 남음
5 3 이면 answer += 5 - 3 => 4
"""
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
