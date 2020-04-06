import heapq


def solution(stock, dates, supplies, k):
    '''
    idea : 해당 기간 안에서 가장 많은 공급을 하는 일자를 택해겠다
    > 이 문제를 먼저 공부하고 디스크 컨트롤러를 풀면 아이디어를 얻을 수 있다
    '''

    answer = 0
    idx = 0
    heap = []

    # stock 이 k 보다 많은 경우에는 더이상 공급바딪 않아도 된다
    while stock < k:
        # 해당 기간에 공급 받을 수 있는 것 중 가장 많은 것을 가져온다
        for i in range(idx, len(dates)):
            if stock < dates[i]: break
            '''
            max heap 을 사용해야하므로 - 를 붙여서 계산한다
            heap push 의 시간복잡도 O(log(n))
            heap은 완전 이진 트리이기 때문에 자식 중 가장 마지막에 노드를 넣고 min heap이면 자신이 더 작으면 위로 계속 올린다
            완전 이진 트리란 왼쪽에서부터 오른쪽으로 순서대로 채워지는 것이다
            
            맨 처음부터 heap을 만드는 경우는 O(nlog(n))의 시간복잡도를 갖는다
            
            삭제의 경우 맨 위의 값을 pop하고 완전 이진 트리를 이용하여 마지막 자식 노드를 root로 올린다
            root로 올린 값들은 아래로 내리면서 제자리를 찾아간다
            따라서 삭제의 경우 시간복잡도가 O(log(n))이다
            '''
            heapq.heappush(heap, -supplies[i])
            idx = i + 1
        # 해당 stock 을 공급받는다
        stock += (heapq.heappop(heap) * -1)
        answer += 1

    return answer


print(solution(5, [5, 6, 10, 15], [20, 21, 20, 10], 30))
