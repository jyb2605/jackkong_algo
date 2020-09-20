from collections import Counter


def solution(participant, completion):
    return list((Counter(participant) - Counter(completion)).elements())[0]


print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]))
