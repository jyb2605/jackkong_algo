def solution(dartResult):
    score = 0
    scores = []
    for i in range(len(dartResult)):
        dart = dartResult[i]
        if dart.isdecimal():
            if (i - 1) >= 0 and dartResult[i - 1].isdecimal():
                scores[-1] = int(str(scores[-1]) + dart)
            else:
                scores.append(int(dart))
        elif dart.isalpha():
            if dart == 'D': scores[-1] **= 2
            if dart == 'T': scores[-1] **= 3
        else:
            if dart == '*':
                if len(scores) >= 1: scores[-1] *= 2
                if len(scores) >= 2: scores[-2] *=2
            if dart == '#': scores[-1] *= -1
    for num in scores: score += num
    return score


print(solution('1S2D*3T'))
print(solution('1D2S#10S'))
print(solution('1D2S0T'))
print(solution('1S*2T*3S'))
print(solution('1D#2S*3S'))
print(solution('1T2D3D#'))
print(solution('1D2S3T*'))
