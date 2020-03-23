'''
programmers stack/queue 기능 개발
'''

import math


def solution(progresses, speeds):
    answer = []
    len_ = len(progresses)
    stack = [0 for _ in range(len_)]
    for i in range(len_):
        stack[i] = math.ceil((100 - progresses[i]) / speeds[i])
    while len(stack):
        count = 1
        day = stack.pop(0)
        while len(stack) and day >= stack[0]:
            stack.pop(0)
            count += 1
        answer.append(count)
    return answer


# def solution(progresses, speeds):
#     Q = []
#     for p, s in zip(progresses, speeds):
#         print(Q)
#         if len(Q) == 0 or Q[-1][0] < -((p - 100) // s):
#             Q.append([-((p - 100) // s), 1])
#         else:
#             Q[-1][1] += 1
#     return [q[1] for q in Q]

# print(solution([93, 30, 55], [1, 30, 5]))
# print(solution([93, 30, 55, 60], [1, 30, 5, 40]))
