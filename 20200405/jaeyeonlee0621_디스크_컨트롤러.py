import heapq
import time


def solution(jobs):
    heap = []
    jobs.sort(key=lambda x: (x[0], x[1]))
    len_ = len(jobs)
    answer = 0
    present_time = 0
    process_end_time = 0

    while jobs or heap:
        print(f'heap : {heap} / time: {present_time} / end: {process_end_time} / answer: {answer}')
        # time.sleep(1)

        while True:
            if jobs and (not heap or jobs[0][0] == present_time):
                time_, process_ = jobs.pop(0)
                if not heap:
                    present_time = time_
                    process_end_time = present_time + process_
                heapq.heappush(heap, (process_, time_))
            else: break

        if present_time == process_end_time:
            if heap:
                process_, time_ = heapq.heappop(heap)
                process_end_time = present_time + process_
                if process_end_time - time_ < 0: answer += process_
                else: answer += (process_end_time - time_)

        present_time += 1

    return int(answer / len_)


# print(solution([[0, 3], [1, 9], [2, 6]]))
# print(solution([[0, 1], [0, 2], [2, 1]]))
print(solution([[0, 3], [1, 9], [500, 6]]))

print(solution([[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 2], [15, 34], [35, 43], [26, 1]]))
# 74

# print(solution([[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]))
# 74
