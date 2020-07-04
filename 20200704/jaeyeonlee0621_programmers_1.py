def solution(name_list):
    for i in range(len(name_list)):
        compare = name_list[i]
        for j in range(len(name_list)):
            if i == j: continue
            if compare in name_list[j]:
                return True
    return False


print(solution(['가을', '우주', '너굴']))
print(solution(['봄', '여름', '봄봄']))
print(solution(['너굴', '너울', '여울', '서울']))
