def solution(distance, rocks, n):
    if len(rocks) == n:
        return distance

    rocks.insert(0, 0)
    rocks.append(distance)
    rocks.sort()

    distances = []

    for i in range(1, len(rocks)):
        distances.append(rocks[i] - rocks[i - 1])

    min_ = 0
    max_ = sum(distances)

    while min_ < max_ - 1:
        mid_ = (min_ + max_) // 2
        remove = 0
        sum_ = distances[0]
        for i in range(1, len(distances)):
            if sum_ < mid_:
                sum_ += distances[i]
                remove += 1
            else:
                sum_ = distances[i]
        if remove > n: max_ = mid_
        else: min_ = mid_
    return min_


print(solution(25, [2, 14, 11, 21, 17], 2))
print(solution(1234, [1, 2, 3], 3))
