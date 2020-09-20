'''
백준 10026 적록색약과 같은 방식으로 풀이
BFS로 근처에 있는 노드부터 방문
연결되어 있는 모든 노드들을 방문했다면 방문했다는 표시를 남김
'''


def solution(n, computers):
    graph = [[] for _ in range(n)]
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if j != i and computers[i][j]: graph[i].append(j)
    answer = 0
    visited = [0 for _ in range(n)]
    for i in range(n):
        if visited[i] == 0:
            visited[i] = 1
            queue = graph[i]
            while queue:
                index = queue.pop(0)
                if visited[index] == 0:
                    visited[index] = 1
                    queue.extend(graph[index])
            answer += 1
    return answer
