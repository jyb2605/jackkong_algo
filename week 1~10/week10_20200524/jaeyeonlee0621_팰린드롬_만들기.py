'''
백준 1213
'''

import string


def solution(name):
    alphabet = [0 for _ in range(26)]

    for n in name:
        alphabet[string.ascii_uppercase.index(n)] += 1

    answer = []
    middle = []
    for index in range(26):
        if alphabet[index] % 2 == 1:
            middle.append(string.ascii_uppercase[index])
            alphabet[index] -= 1
    if len(middle) > 1:
        return "I'm Sorry Hansoo"
    for index in range(26):
        for i in range(int(alphabet[index] / 2)):  # 이 부분을 간과해서 오류 발생
            answer.append(string.ascii_uppercase[index])
    if middle:
        answer.append(middle[0])
    for index in range(25, -1, -1):
        for i in range(int(alphabet[index] / 2)):  # 이 부분을 간과해서 오류 발생
            answer.append(string.ascii_uppercase[index])
    return ''.join(answer)


name = input()
print(solution(name))

# ex) AAABB
