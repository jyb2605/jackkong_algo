import sys
import string


def solution(name):
    alphabet = [0 for _ in range(27)]
    name = name[:-1]

    for n in name:
        alphabet[string.ascii_uppercase.index(n)] += 1

    answer = []
    middle = ''
    count = 0
    for index in range(27):
        if alphabet[index] % 2 == 1:
            if count > 1:
                return "I'm Sorry Hansoo"
            count += 1
            middle = string.ascii_uppercase[index]
            alphabet[index] -= 1

    for index in range(27):
        if alphabet[index] > 0:
            answer.append(string.ascii_uppercase[index])
    if middle:
        answer.append(middle)
    for index in range(26, -1, -1):
        if alphabet[index] > 0:
            answer.append(string.ascii_uppercase[index])
    return ''.join(answer)


name = sys.stdin.readline()
print(solution(name))

# print(solution('AABB'))
# print(solution('AACCCBB'))
# print(solution('AADDDCCCBB'))
# print(solution('ACABCB'))
