import heapq


def solution(n, t, m, timetable):
    crew = []
    for index in range(len(timetable)):
        hour, minute = timetable[index].split(':')
        heapq.heappush(crew, 60 * int(hour) + int(minute))

    bus_time = 9 * 60
    last_time = 9 * 60 + (n - 1) * t
    bus = []
    for _ in range(n):
        count = 0
        while crew and count < m and crew[0] <= bus_time:
            count += 1
            crew_time = heapq.heappop(crew)
            if bus_time == last_time:
                bus.append(crew_time)
        bus_time += t

    if len(bus) == m:
        last_time = bus[-1] - 1

    return f'{str(int(last_time / 60)).zfill(2)}:{str(int(last_time % 60)).zfill(2)}'


print(solution(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]))
print(solution(2, 10, 2, ["09:10", "09:09", "08:00"]))
print(solution(2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]))
print(solution(1, 1, 5, ["00:01", "00:01", "00:01", "00:01", "00:01"]))
print(solution(1, 1, 1, ["23:59"]))
print(solution(10, 60, 45,
               ["23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59"]))
