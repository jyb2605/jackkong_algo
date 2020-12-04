import sys


def solution(phone_book):
    for i in range(len(phone_book) - 1):
        if phone_book[i + 1].startswith(phone_book[i]):
            return False
    return True


n = int(sys.stdin.readline())
for _ in range(n):
    phone_book = []
    m = int(sys.stdin.readline())
    for _ in range(m):
        phone_book.append(str(sys.stdin.readline())[:-1])
    phone_book.sort()
    print('YES' if solution(phone_book) else 'NO')
