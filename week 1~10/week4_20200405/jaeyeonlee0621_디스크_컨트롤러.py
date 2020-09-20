import heapq


def solution(jobs):
    '''
    idea : 이전 프로세스가 실행을 완료한 시간의 이전 시간에 들어온 프로세스 중 실행 시간이 가장 낮은 것을 가져온다
    > 가장 낮은 프로세스 시간의 값을 가져올 때 min heap 을 사용한다

    Python 의 sort 의 경우 merge sort 로 nlog(n) 의 시간 복잡도를 가지고 있다
    key 를 두개로 하고 싶다면 tuple 을 사용하면 된다
    '''
    jobs.sort(key=lambda x: (x[0], x[1]))
    # 기본적으로 heap 에 처음 것은 넣어준다
    heap = [(jobs[0][1], jobs[0][0])]
    # 처음 것은 넣어주었기 때문에 index 는 0이 아닌 1이다
    start = 1
    answer = 0
    # 만약에 process 가 15부터 시작할 때는 process time 이 0이면 답이 나오지 않기 때문에 첫번째 job 부터 시작한다
    process_time = jobs[0][0]

    while True:
        # 실행할 프로세스가 모두 완료되었다면 완료한다
        if start == len(jobs) and not heap: break

        # 이전 프로세스가 완료된 시점 이전에 들어온 프로세스를 모두 heap 에 넣는다
        for index in range(start, len(jobs)):
            if jobs[index][0] <= process_time:
                heapq.heappush(heap, (jobs[index][1], jobs[index][0]))
                start = index + 1

        # 만약 job 이 모두 실행되지 않았는데 해당 시간에 실행할 프로세스가 없다면
        # 현재 놀고 있으므로 다음 프로세스를 강제로 가져온다
        if start != len(jobs) and not heap:
            process_time = jobs[start][0]
            continue

        # 다음 프로세스를 실행한다
        process, time = heapq.heappop(heap)
        # 이 프로세스가 완료된 시간을 저장한다
        process_time += process
        # 프로세스가 완료된 시간에서 시작 시간을 계산하면 기다린 시간을 구할 수 있다
        answer += process_time - time
    return int(answer / len(jobs))


print(solution([[0, 3], [1, 9], [2, 6]])) # 9
print(solution([[0, 1], [0, 2], [2, 1]])) # 2
print(solution([[0, 3], [1, 9], [500, 6]])) # 6
print(solution([[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 2], [15, 34], [35, 43], [26, 1]])) # 74
print(solution([[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]])) # 74
