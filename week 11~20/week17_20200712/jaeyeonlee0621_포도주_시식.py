'''
1. 먹음 + 다음 것도 먹음 + 한 칸 띄고 + dp
2. 안먹음 = 그 전꺼 들고옴
3. 먹음 + 다음 것 안 먹음 + dp
'''
import sys

n = int(sys.stdin.readline())

wine = [0 for _ in range(n + 3)]
for i in range(n): wine[i] = int(sys.stdin.readline())
dp = [0 for _ in range(n + 3)]

for i in range(n - 1, -1, -1):
    dp[i] = max(wine[i] + wine[i + 1] + dp[i + 3], dp[i + 1], wine[i] + dp[i + 2])

print(dp[0])
