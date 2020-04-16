import enum


class Alphabet(enum.Enum):
    A = 0
    B = 1
    C = 2
    D = 3
    E = 4
    F = 5
    G = 6
    H = 7
    I = 8
    J = 9
    K = 10
    L = 11
    M = 12
    N = 13
    O = 14
    P = 15
    Q = 16
    R = 17
    S = 18
    T = 19
    U = 20
    V = 21
    W = 22
    X = 23
    Y = 24
    Z = 25


def move(present, name, visited, move_):
    index = (present + move_) % len(name)
    count = 1
    while True:
        if index == present: break
        if name[index] != 'A' and visited[index] == 0: break
        index = (index + move_ + len(name)) % len(name)
        count += 1
    return (index, count)


def solution(name):
    answer = 0
    visited = [0 for _ in range(len(name))]
    node = 0
    while True:
        answer += min(Alphabet[name[node]].value, 26 - Alphabet[name[node]].value)
        visited[node] = 1
        right_index, right_count = move(node, name, visited, 1)
        left_index, left_count = move(node, name, visited, -1)
        if right_index == node or left_index == node: break
        if right_count < left_count:
            node = right_index
            answer += right_count
        else:
            node = left_index
            answer += left_count
    return answer


print(solution('BBAABB'))
print(solution('AZAAAZ')) # 5
print(solution('ABABAAAAAAABA'))
print(solution("JAZ")) # 11
print(solution("JEROEN"))
print(solution("JAN"))
