import string


def solution(name):
    answer = 0
    move = len(name)
    for i in range(len(name)):
        answer += min(string.ascii_uppercase.index(name[i]), 26 - string.ascii_uppercase.index(name[i]))
        next_ = i + 1
        while next_ < len(name) and name[next_] == 'A': next_ += 1
        move = min(move, i + len(name) - next_ + min(i, len(name) - i))
    answer += move
    return answer


print(solution('BBAABB'))
print(solution('AZAAAZ'))  # 5
print(solution('ABABAAAAAAABA'))
print(solution("JAZ"))  # 11
print(solution("JEROEN"))
print(solution("JAN"))
