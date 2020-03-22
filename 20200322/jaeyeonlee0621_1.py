'''
programmers 탑
'''


def solution(heights):
    len_ = len(heights)
    answer = [0 for _ in range(len_)]
    for i in range(0, len_):
        for idx in range(i, -1, -1):
            if heights[idx] > heights[i]:
                answer[i] = idx + 1
                break
    return answer
