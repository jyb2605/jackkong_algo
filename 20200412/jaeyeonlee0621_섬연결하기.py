# Prim Algorithm
import heapq


def solution(n, costs):
    map = [[] for _ in range(n)]
    for start, end, cost in costs:
        map[start].append((end, cost))
        map[end].append((start, cost))
    visited = [0 for _ in range(n)]
    visited[0] = 1
    visited_count = 1
    answer = 0
    while visited_count != n:
        heap = []
        for i in range(n):
            if visited[i]:
                for node, cost in map[i]:
                    if visited[node] == 0: heapq.heappush(heap, (cost, node))
        cost, node = heapq.heappop(heap)
        visited[node] = 1
        answer += cost
        visited_count += 1
    return answer


print(solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))