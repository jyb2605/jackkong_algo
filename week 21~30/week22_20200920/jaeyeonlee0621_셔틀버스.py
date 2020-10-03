import heapq


def solution(n, t, m, timetable):
    crew = []
    for index in range(len(timetable)):
        hour, minute = timetable[index].split(':')
        heapq.heappush(crew, 60 * int(hour) + int(minute))

    bus_time = 9 * 60
    bus = {}
    for _ in range(n):
        bus[bus_time] = []
        while crew and len(bus[bus_time]) < m:
            crew_time = crew[0]
            if crew_time > bus_time:
                break
            bus[bus_time].append(heapq.heappop(crew))
        bus_time += t

    last_time = 9 * 60 + (n - 1) * t
    if len(bus[last_time]) == m:
        min_crew_time = bus[last_time][0]
        count = 0
        for crew_time in bus[last_time]:
            if min_crew_time == crew_time:
                count += 1
        last_time = min_crew_time
        if count == m:
            last_time = min_crew_time - 1

    return f'{str(int(last_time / 60)).zfill(2)}:{str(int(last_time % 60)).zfill(2)}'


print(solution(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]))
print(solution(2, 10, 2, ["09:10", "09:09", "08:00"]))
print(solution(2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]))
print(solution(1, 1, 5, ["00:01", "00:01", "00:01", "00:01", "00:01"]))
print(solution(1, 1, 1, ["23:59"]))
print(solution(10, 60, 45,
               ["23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59"]))
