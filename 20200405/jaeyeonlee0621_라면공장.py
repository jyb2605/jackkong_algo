import heapq


def solution(stock, dates, supplies, k):
    '''
    idea : 해당 기간 안에서 가장 많은 공급을 하는 일자를 택해겠다

    '''

    answer = 0
    idx = 0
    heap = []

    while stock < k:
        for i in range(idx, len(dates)):
            if stock < dates[i]: break
            heapq.heappush(heap, -supplies[i])
            idx = i + 1
        stock += (heapq.heappop(heap) * -1)
        answer += 1

    return answer


print(solution(5, [5, 6, 10, 15], [20, 21, 20, 10], 30))
