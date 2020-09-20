'''
1,2,3 더하기와 마찬가지로
2개의 수를 이용해서 해당 숫자를 만들려면
n-1, n-2 를 더하면 된다
'''
import sys

n = int(sys.stdin.readline())

if n <= 2:
    print(n)
if n >= 3:
    one = 1
    two = 2
    three = 0
    for i in range(n - 2):
        three = (one + two)
        one = two % 10007
        two = three % 10007
    print(three % 10007)
