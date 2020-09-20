import math
from copy import copy
def solution(str1, str2):
    answer = 0
    
    str_1 = []
    str_2 = []
    dic_1 = {}
    dic_2 = {}
    
    for i in range(len(str1)):
        if i+1 >= len(str1):
            break
        tmp_str = str1[i] + str1[i+1]
        if tmp_str.isalpha():
            tmp = tmp_str.lower()
            str_1.append(tmp)
            
    for i in range(len(str2)):
        if i+1 >= len(str2):
            break
        tmp_str = str2[i] + str2[i+1]
        if tmp_str.isalpha():
            tmp = tmp_str.lower()
            str_2.append(tmp)

    # add_group = 1 if len(set(str_1) | set(str_2)) == 0 else len(set(str_1) | set(str_2))
    # min_group = 1 if len(set(str_1) & set(str_2))== 0 else len(set(str_1) & set(str_2))
    
    for i in str_1:
        if i in dic_1:
            dic_1[i] += 1
        else:
            dic_1[i] = 1
    
    for i in str_2:
        if i in dic_2:
            dic_2[i] += 1
        else:
            dic_2[i] = 1
    
    # 교집합
    min_dic = {}
    min_num = 0
    for k in dic_1:
        if k in dic_2:
            min_dic[k] = min(dic_2[k], dic_1[k]) 
            min_num += min_dic[k]

    # 합집합
    add_dic = dic_1
    add_num = 0
    for k in dic_2:
        if k in add_dic:
            add_dic[k] = max(dic_2[k], add_dic[k])
        else:
            add_dic[k] = dic_2[k]
    for k in add_dic:
        add_num += add_dic[k]
    
    if add_num+min_num == 0:
        answer = 65536
    elif add_num+min_num == 1:
        if add_num == 1:
            answer = (min_num/1)*65536
        else:
            answer = (1/add_num)*65536
    else:
        answer = (min_num/add_num)*65536
        
    return math.trunc(answer)
