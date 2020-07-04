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
