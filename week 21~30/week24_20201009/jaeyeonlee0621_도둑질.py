# https://programmers.co.kr/learn/courses/30/lessons/42897

def solution(money):
    dp = [[money[i] for i in range(len(money) - 1)] for _ in range(2)]
    for i in range(2, len(money) - 1):
        if i - 2 >= 0:
            dp[0][i] += max(dp[0][i - 2], dp[1][i - 2])
        if i - 3 >= 0:
            dp[1][i] += max(dp[0][i - 3], dp[1][i - 3])
    answer = max(max(dp[0]), max(dp[1]))

    dp = [[money[i] for i in range(1, len(money))] for _ in range(2)]
    for i in range(2, len(money) - 1):
        if i - 2 >= 0:
            dp[0][i] += max(dp[0][i - 2], dp[1][i - 2])
        if i - 3 >= 0:
            dp[1][i] += max(dp[0][i - 3], dp[1][i - 3])
    answer = max(answer, max(max(dp[0]), max(dp[1])))

    return answer


print(solution([1, 2, 3, 1]))
