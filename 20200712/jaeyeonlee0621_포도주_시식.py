'''
dp 진짜 어렵다
이런 생각들을 어떻게 하는거지
'''
import sys

n = int(sys.stdin.readline())

wine = []
for i in range(n): wine.append(int(sys.stdin.readline()))

if n == 1:
    print(wine[0])
else:
    dp = [0 for _ in range(n)]
    dp[0] = wine[0]
    dp[1] = wine[0] + wine[1]

    '''
    내 차례에 가질 수 있는 경우의 수는 3가지 이다.
    1. 지금 와인 X
    2. 지금 와인 O, 이전 와인 X
    3. 지금 와인 O, 이전 와인 O
    '''
    for i in range(2, n):
        dp[i] = max(dp[i - 1], wine[i] + dp[i - 2], wine[i] + wine[i - 1] + dp[i - 3])

    print(dp[n - 1])
