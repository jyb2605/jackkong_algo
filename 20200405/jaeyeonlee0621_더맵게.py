import heapq


def solution(scoville, K):
    """
    가장 작은 수를 뽑기 위하여 min heap 을 사용하였습니다.
    가장 작은 수가 K 보다 크면 이후의 값들은 모두 K 보다 크기 때문에 스코빌 지수를 맞출 수 있습니다.
    가장 작은 수가 K 보다 작을 때는 해당 문제에서 제시한 조건과 같이 가장 작은 2개의 수를 계산하여 다시 heap 에 넣습니다.
    해당 계산을 수행한 후 섞은 수를 1을 더해줍니다.
    만약 가장 작은 수가 K 보다 작지만 heap 이 1 이라면 즉 더 이상 섞을 수 없다면 해당 음식의 스코빌 지수를 K 로 맞출 수 없음으로 -1 을 리턴합니다.

    heap 의 삽입 시간 복잡도는 log(n) 이며 삭제 시간 복잡도 또한 log(n) 입니다.
    처음 heap 을 생성할 때는 1개의 노드가 log(n)을 수행해야하므로 nlog(n)의 시간이 소요됩니다.

    따라서 처음 정렬시 O(nlog(n)) 의 시간이 걸립니다.
    반목문의 경우에는 최악의 경우 n-1 번이 반복되게 되며, 반목문 안에는 삽입과 삭제 기능이 수행되므로 O(log(n))의 수행시간이 걸리게 됩니다.
    즉 총 O(nlog(n))의 시간이 걸릴 것으로 예상됩니다.
    """
    heap = []
    for i in scoville: heapq.heappush(heap, i)
    count = 0
    while heap[0] < K:
        if len(heap) == 1: return -1
        i = heapq.heappop(heap)
        heapq.heappush(heap, i + (heapq.heappop(heap) * 2))
        count += 1
    return count