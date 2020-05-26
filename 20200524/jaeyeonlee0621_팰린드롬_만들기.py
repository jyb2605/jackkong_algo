import string
import copy


def solution(name):
    alphabet = [0 for _ in range(26)]

    for n in name:
        alphabet[string.ascii_uppercase.index(n)] += 1

    middle = []
    word = []
    for index in range(26):
        if alphabet[index] % 2 == 1:
            middle.append(string.ascii_uppercase[index])
            alphabet[index] -= 1
        if alphabet[index] > 0 and alphabet[index] % 2 == 0:
            word.append(string.ascii_uppercase[index])
    if len(middle) > 1:
        return "I'm Sorry Hansoo"
    answer = copy.deepcopy(word)
    if middle:
        answer.append(middle[0])
    for index in range(len(word) - 1, -1, -1):
        answer.append(word[index])
    return ''.join(answer)


name = input()
print(solution(name))

# print(solution('AAAB'))
# print(solution('AACCCBB'))
# print(solution('AADDDCCCBB'))
# print(solution('ACABCB'))
