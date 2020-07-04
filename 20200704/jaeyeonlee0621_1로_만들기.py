'''
저장하는 것 : 해당 숫자를 만드는 최소 개수
해야 할일
    1. 2으로 나누어 떨어지면 2
    2. 3으로 나누어 떨어지면 3
    3. 1을 빼기
1이 되면 count의 최소 개수

parameter : num (현재 수), count (이 전의 수)
if num == 1:
    answer = min(answer, count)
    return answer
if map_[num] != DEFAULT_VALUE:
    return map_[num]
if n % 2 == 0:
    num1 = dp(n//2, count + 1)
if n % 3 == 0:
    num2 = dp(n/3, count + 1)
if n - 1 >= 1:
    num3 = dp(n-1, count + 1)
map_[num] = min(num1, num2, num3)
'''