count = 99


def dp(reserve, present, n):
    global count
    if count > n: count = n
    if count == 0 or n == 0: return
    for i in reserve:
        if present[i] == 1:
            if i > 0 and present[i - 1] == -1:
                present[i - 1] = 0
                present[i] = 0
                dp(reserve, present, n - 1)
                present[i - 1] = -1
                present[i] = 1
            if i < len(present) - 1 and present[i + 1] == -1:
                present[i + 1] = 0
                present[i] = 0
                dp(reserve, present, n - 1)
                present[i + 1] = -1
                present[i] = 1


def solution(n, lost, reserve):
    student = [0 for _ in range(n + 1)]
    for i in lost: student[i] += -1
    for i in reserve: student[i] += 1
    global count
    count = 99
    dp(list(set(reserve) - set(lost)), student, len(set(lost) - set(reserve)))
    return n - count