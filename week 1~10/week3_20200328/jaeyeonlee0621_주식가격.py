def solution(prices):
    len_ = len(prices)
    answer = [0 for _ in range(len_)]
    for i in range(len_):
        answer[i] = len_ - 1 - i
        for j in range(i + 1, len_):
            if prices[i] > prices[j]:
                answer[i] = j - i
                break
    return answer


print(solution([1, 2, 3, 2, 3]))
