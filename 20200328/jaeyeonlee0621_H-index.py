def solution(citations):
    len_ = len(citations)
    citations = sorted(citations)
    for i in range(len_):
        if citations[i] >= len_ - i: return len_ - i
    return 0


print(solution([3, 0, 6, 1, 5]))

'''
def solution(citations):
    citations.sort(reverse=True)
    answer = max(map(min, enumerate(citations, start=1)))
    return answer
'''
