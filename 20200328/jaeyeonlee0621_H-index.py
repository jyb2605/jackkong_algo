def solution(citations):
    len_ = len(citations)
    citations = sorted(citations)
    max_ = 0
    for i in range(len_ - 1, -1, -1):
        count = len_ - i
        if citations[i] >= count: max_= count
    return max_


print(solution([3, 0, 6, 1, 5]))