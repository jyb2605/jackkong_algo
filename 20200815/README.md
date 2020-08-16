## 최단 거리 탐색 알고리즘
- start 부터 end 까지의 최단 거리

### 플로이드 와샬
- start 지점이 고정되어있지 않음 -> 모든 지점에서 해당 지점으로 가는 최단 거리를 한 번에 구할 수 있음
- for 문이 3번 도는 게 특징 -> 그러나 구현은 심플
- 모든 점에서 그 점을 거쳐가는 값을 계산하고 작은 값을 업데이트 -> 그래서 시간이 조금 느림
```python
map_[start][end] = min(map_[start][end], map_[start][i] + map_[i][end])
```

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
  현재 weight와 cost의 합이 현재 node에 갈 수 있는 비용보다 작다면 해당 지점을 거쳐서 가도록 수정  
```python
while queue:
    weight, start = heappop(queue)
    for cost, node in map_[start]: # 현재 노드에서 연결된 노드들
        if cost + weight < destination[node]: # 연결된 노드들로 가는 거리 값보다 현재 노드를 거쳐가는 것이 더 빠르다면
            destination[node] = cost + weight # 거쳐가도록 수정
            heappush(queue, [destination[node], node]) 
```
  