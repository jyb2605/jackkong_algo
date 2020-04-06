def solution(operations):
    map_ = []
    for oper in operations:
        oper_ = oper.split(' ')
        if oper_[0] == 'D':
            if map_:
                if oper_[1] == '-1': map_.pop()
                if oper_[1] == '1': map_.pop(0)
        else:
            map_.append(int(oper_[1]))
            map_.sort(reverse=True)
    if map_: return [map_[0], map_[-1]]
    return [0, 0]


print(solution(["I 16", "D 1"]))
print(solution(["I 7", "I 5", "I -1", "D -1"]))
print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))
