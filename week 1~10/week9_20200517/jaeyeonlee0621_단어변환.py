'''
단어 문자가 하나씩 다른 것끼리 그래프를 만듬
BFS를 이용하여 최소인 수를 구함
'''


def solution(begin, target, words):
    if target not in words: return 0
    length_ = len(begin)
    words.insert(0, begin)
    words_length_ = len(words)

    map_ = [[] for _ in range(words_length_)]
    visited_ = [0 for _ in range(words_length_)]

    for x in range(words_length_):
        for y in range(words_length_):
            if x == y: continue
            diff_count = 0
            for i in range(length_):
                if diff_count > 1: break
                if words[x][i] != words[y][i]: diff_count += 1
            if diff_count == 1: map_[x].append(y)

    answer = 60
    queue = [(index, 1) for index in map_[0]]
    visited_[0] = 1

    while queue:
        index, count = queue.pop(0)
        if words[index] == target: answer = min(answer, count)
        if visited_[index] == 0:
            visited_[index] = 1
            queue.extend([(i, count + 1) for i in map_[index]])

    if answer == 60: return 0
    return answer


print(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log', 'cog']))
