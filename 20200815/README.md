## 최단 거리 탐색 알고리즘
- start 부터 end 까지의 최단 거리

<br/>

### 플로이드 와샬
- start 지점이 고정되어있지 않음 -> 모든 지점에서 해당 지점으로 가는 최단 거리를 한 번에 구할 수 있음
- for 문이 3번 도는 게 특징 -> 구현은 심플 but 시간이 조금 느림
- 모든 점에서 그 점을 거쳐가는 값을 계산하고 작은 값을 업데이트 
```python
map_[start][end] = min(map_[start][end], map_[start][i] + map_[i][end])
```

<br/>

### 다익스트라
- `start (고정) -> end (모든 노드)` 갈 수 있는 거리의 weight 을 담은 list 생성 (default = INF)
```python
INF = 1e9

destination = [INF for _ in range(nodes_count)]
```
- 시작은 start 부터 하므로 queue에 [weight, start] 즉 [0, start] push
```python
queue = [[0, start]]
```
- 이후 start 에서 연결된 지점들 (각 지점들은 node 라고 칭함) 그 node로 가는 weight (cost로 창함) 에 대해 
- **weight와 cost의 합이 현재 node에 갈 수 있는 비용보다 작다면 해당 지점을 거쳐서 가도록 수정**  
```python
while queue:
    weight, start = heappop(queue)
    for cost, node in map_[start]: # 현재 노드에서 연결된 노드들
        if cost + weight < destination[node]: # 현재의 거리 값보다 해당 노드를 거쳐가는 것이 더 빠르다면
            destination[node] = cost + weight # 거쳐가도록 수정
            heappush(queue, [destination[node], node]) 
```

 <hr/>
 
 ## Minimum Spanning Tree (MST)
 - 최소 비용으로 모든 정점을 연결하는 트리

<br/>
 
 ### 크루스칼 알고리즘
 - greedy algorithm
 - 가중치가 가장 적은 것부터 pick
 - 만약 그 간선을 이었을 때 cycle이 생성된다면 해당 간선은 연결하지 않는다

<br/>
 
 ### 프림 알고리즘
 - 선택 노드의 연결된 간선을 모두 min heap(logN) 에 넣고
 - 작은 것을 빼고 사이클이 없는 것을 확인하고 연결 시킴 (heap이 비어있을 때까지)
 
 <hr/>
 
 ## 사이클 확인 방법
 - 부모 찾기
```python
parent = [i for i in range(nodes_count)] # 처음엔 자기 자신의 자신의 부모


def find(node):
    if parent[node] != node: # 자기 자신이 부모 == 최상위 부모
        parent[node] = find(parent[node]) # 최상위 부모를 찾아 떠나는 여행
    return parent[node]
``` 

<br/>

- 단 최상위 부모가 누구인지 알아야 한다
```python
'''
여기서 0과 2를 연결한다고 가정하자 
그렇다면 0의 부모값을 변경해야할까 2의 부모값을 변경해야 할까
-> 최상위 부모가 누구인지로 결정할 수 있다

이 코드에서는 rank라는 것을 두어 최상위 부모를 체크한다
'''

parent = [0, 1, 1]
rank = [0, 1, 0] # 1이 최상위 부모인 것을 알 수 있음

if rank[0] < rank[1]: # 1이 최상위 부모라면 0이 1을 부모로 가진다
    parent[0] = 1
else:
    parent[1] = 0 # 만약 아니라면 1은 0을 부모로 가지고
    if rank[0] == rank[1]: # 최상위 부모 여부가 표시가 되어있지 않다면
        rank[0] += 1 # 0이 최상위 부모인 것을 알린다
```