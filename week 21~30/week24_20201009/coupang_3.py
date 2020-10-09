import collections


def solution(k, score):
    diff = [0 for _ in range(len(score))]

    for i in range(1, len(diff)):
        diff[i] = score[i - 1] - score[i]

    container = collections.Counter(diff)

    keys = []
    for key, value in container.items():
        if value >= k:
            keys.append(key)

    for i in range(1, len(diff)):
        if diff[i] in keys:
            score[i - 1] = 0
            score[i] = 0

    answer = 0
    for i in range(len(score)):
        if score[i] != 0:
            answer += 1

    return answer


print(solution(3, [24, 22, 20, 10, 5, 3, 2, 1]))
print(solution(2, [1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638, 157658634,
                   100000000, 100]))
