'''
programmers 완주하지 못한 선수
'''

from collections import Counter


def solution(participant, completion):
    return list((Counter(participant) - Counter(completion)).elements())[0]
