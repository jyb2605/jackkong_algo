import sys

N, M = list(map(str, sys.stdin.readline().rstrip().split(' ')))
N = int(N)
M = int(M)
arr = list(map(str, sys.stdin.readline().rstrip().split(' ')))

arr = [int(i) for i in arr]
pointer1 = 0
pointer2 = 0
answer = 0
tmp = 0

while pointer1 < N:
    if pointer2 == N:
        break
    tmp += arr[pointer2]

    if tmp >= M:
        if tmp == M:
            answer += 1
        pointer1 += 1
        pointer2 = pointer1
        tmp = 0
    else:
        pointer2 += 1
print(answer)
