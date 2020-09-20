def solution(n, arr1, arr2):
    answer = []
    
    for i in range(len(arr1)):
        tmp_str = "{0:016b}".format(int(arr1[i]))
        arr1[i] = tmp_str[-n:]
        
    for i in range(len(arr2)):
        tmp_str = "{0:016b}".format(int(arr2[i]))
        arr2[i] = tmp_str[-n:]
    
    for a1, a2 in zip(arr1, arr2):
        tmp_str = ""
        for b1, b2 in zip(a1, a2):
            cmp_ = int(b1)+int(b2)
            if cmp_ == 0:
                tmp_str += ' '
            else:
                tmp_str += '#'
        answer.append(tmp_str)
    return answer
