def solution(people, limit):
    people.sort()
    move = [0 for _ in range(len(people))]
    answer = 0
    start = 0
    end = len(people) - 1
    while start > -1:
        move[start] = 1
        for i in range(end, -1, -1):
            if move[i] == 0:
                move[i] = 1
                end = i
                if (people[start] + people[i]) <= limit: break
                else: answer += 1
        answer += 1
        for i in range(start + 1, len(people)):
            start = -1
            if move[i] == 0:
                start = i
                break
    return answer


print(solution([70, 50, 80, 50], 100))
print(solution([70, 80, 50], 100))
