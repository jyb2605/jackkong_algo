import bisect


def solution(participant, completion):
    answer = ''
    len_ = len(participant)
    for idx in range(len_):
        if not (participant[idx] in completion):
            answer = participant[idx]
            break
    return answer

solution(["leo", "kiki", "eden"], ["eden", "kiki"])

solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"])

