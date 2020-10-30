def solution(answers):
    student = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    scores = [0, 0, 0]

    for i in range(3):
        score = 0
        for j in range(len(answers)):
            if answers[j] == student[i][j % len(student[i])]:
                score += 1
        scores[i] = score

    answer = []
    highest_score = max(scores)
    for i in range(len(scores)):
        if scores[i] == highest_score:
            answer.append(i + 1)

    return answer


print(solution([1, 2, 3, 4, 5]))
print(solution([1, 3, 2, 4, 2]))
print(solution([4, 4, 4, 5, 1]))
