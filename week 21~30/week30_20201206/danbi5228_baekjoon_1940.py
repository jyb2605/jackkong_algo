import sys
N = int(input())
M = int(input())
arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))
arr.sort()
start, end = 0, N-1
result = 0

while start < end:
    if arr[start] + arr[end] == M:
        result += 1
        start += 1
        end -= 1
    elif arr[start] + arr[end] < M:
        start += 1
    else:
        end -= 1
print(result)

# 런타임에러
# import sys2467
# N = int(input())
# M = int(input())
# arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))
# arr.sort()
# p1 = 0
# result = 0
# while True:
#     if arr[p1] != 0:
#         try:
#             tmp = arr.index(M - arr[p1])
#         except ValueError:
#             p1 += 1
#             continue
#         result += 1
#         arr[p1] = 0
#         arr[tmp] = 0
#     p1 += 1
#
#     if p1 == N:
#         break
#
# print(result)

# 시간초과

# import sys
# N = int(input())
# M = int(input())
# arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))
#
# p1 = 0
# p2 = 1
# result = 0
#
# while p1 < N:
#     if p2 >= N:
#         p1 += 1
#         p2 = p1 + 1
#
#         if p1 == N-1:
#             break
#     if arr[p1] + arr[p2] == M:
#         result += 1
#     p2 += 1
#
# print(result)