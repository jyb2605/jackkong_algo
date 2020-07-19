'''
뒤에서 부터

5  4  3  2  1  1  2  3  4  5
50 40 30 20 10 10 20 30 40 50
                  20 30 0  0
여기서 부터 문제가 생김
만약 1, 10 의 상담을 진행한 후 바로 다음이 아닌 다다음 날의 상담을 잡았을 때
더 많은 가격을 받을 수 있음
따라서 해당 값은 지난 값들의 최댓값이어야한다

5  4  3  2  1  1  2  3  4  5
50 40 30 20 10 10 20 30 40 50
90 80 70 60 50 40 30 30 0  0
--

'''
import sys

n = int(sys.stdin.readline())

council = []
dp = [0 for _ in range(n + 1)]

for _ in range(n):
    council.append(list(map(int, sys.stdin.readline().split())))

for i in range(n - 1, -1, -1):
    day, money = council[i][0], council[i][1]
    if i + day <= n: dp[i] = money + dp[i + day]
    if i + 1 <= n and dp[i + 1] > dp[i]: dp[i] = dp[i + 1]

print(dp[0])
