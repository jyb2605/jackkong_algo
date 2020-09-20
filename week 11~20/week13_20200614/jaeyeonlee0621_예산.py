def solution(budgets, M):
    min_ = 0
    max_ = max(budgets) + 1
    while True:
        mid_ = int((min_ + max_) / 2)
        if mid_ == min_ or mid_ == max_: return mid_
        sum = 0
        for budget in budgets:
            if budget >= mid_:
                sum += mid_
            else:
                sum += budget
        if sum >= M: max_ = mid_
        if sum < M: min_ = mid_
