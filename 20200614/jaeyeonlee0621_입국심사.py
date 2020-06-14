def solution(n, times):
    min_ = 0
    max_ = 0

    for t in times: max_ = max(max_, n * t)

    while min_ < max_ - 1:
        mid_ = (min_ + max_) // 2
        sum_ = 0
        for t in times: sum_ += mid_ // t
        if sum_ < n: min_ = mid_
        if sum_ >= n: max_ = mid_

    return max_


# print(solution(6, [7, 10]))
# print(solution(10, [1, 5]))
# print(solution(1, [2, 2]))
# print(solution(1000000000, [1, 1000000000, 1000000000]))

print(solution(6, [7,10])) # 28
print(solution(6, [6,10])) # 24
print(solution(6, [8,10])) # 30
print(solution(6, [4, 10]))  # 20
print(solution(11, [3,4,10])) # 18
print(solution(5, [1,1,10])) # 3
