def solution(priorities, location):
    len_ = len(priorities)
    stack = [0 for _ in range(0, 10)]
    for i in range(0, len_): stack[priorities[i]] += 1
    start = 0
    count = 0
    for i in range(9, -1, -1):
        while stack[i]:
            if priorities[start] == i:
                count += 1
                stack[i] -= 1
                if start == location: return count
            start = (start + 1) % len_
    return count


print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))
