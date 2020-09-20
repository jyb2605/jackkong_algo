def solution(number, k):
    stack = []
    for i in range(0, len(number)):
        while k > 0 and stack and stack[-1] < number[i]:
            stack.pop()
            k -= 1
        stack.append(number[i])
    return ''.join(stack[:len(stack) - k])


# print(solution('1924', 2))
# print(solution('1231234', 3))
print(solution('4177252841', 4))
