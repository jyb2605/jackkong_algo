'''
1. 글자로 들어오는 나라의 종류를 얻는다
2. 나라를 알파벳순으로 나타낸다
3. 알파벳순으로 나타낸 값들에 번호를 붙인다
4. 시작 나라부터 도착 나라까지 티켓이 몇 장이 있는 지 더한다
5. DFS를 이용하여 해당 모든 티켓을 다 사용했으면 return을 하는 로직을 만든다
6. integer로 들어온 값들을 다시 나라 이름으로 변경한다
'''

import sys

sys.setrecursionlimit(100000)

answer = []


def dp(nation, count, ticket_count, map_):
    global answer
    if count == ticket_count: return True
    for i in range(len(map_[nation])):
        if map_[nation][i] > 0:
            map_[nation][i] -= 1
            answer.append(i)
            count += 1
            if dp(i, count, ticket_count, map_): return True
            map_[nation][i] += 1
            answer.pop()
            count -= 1
    return False


def solution(tickets):
    global answer
    node = []
    index = {}
    for from_, to_ in tickets:
        if from_ not in node: node.append(from_)
        if to_ not in node: node.append(to_)
    node.sort()
    for i in range(len(node)): index[node[i]] = i
    answer = [index['ICN']]
    map_ = [[0 for _ in range(len(node) + 1)] for _ in range(len(node) + 1)]
    for from_, to_ in tickets: map_[index[from_]][index[to_]] += 1
    dp(index['ICN'], 0, len(tickets), map_)
    for i in range(len(answer)):
        for key, item in index.items():
            if answer[i] == item:
                answer[i] = key
                break
    return answer


# print(solution([['ICN', 'JFK'], ['HND', 'IAD'], ['JFK', 'HND']]))
# print(solution([['ICN', 'SFO'], ['ICN', 'ATL'], ['SFO', 'ATL'], ['ATL', 'ICN'], ['ATL', 'SFO']]))
print(solution([['ICN', 'SFO'], ['SFO', 'ICN'], ['ICN', 'SFO'], ['SFO', 'QRE']]))
