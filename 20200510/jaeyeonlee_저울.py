def solution(weight):
    weight.sort()
    sum_ = 0
    for i in range(0, len(weight)):
        if sum_ + 1 < weight[i]: break
        sum_ += weight[i]
    return sum_ + 1


print(solution([2, 3, 4]))
print(solution([3, 1, 6, 2, 7, 30, 1]))

'''
- 만들 수 있는 것 중에 가장 작은 수는 "현재 더한 값 + 1" 이다
- 만약 현재 더한 값 + 1 즉 만들 수 있는 것 중에 가장 작은 수가 다음 오는 추의 무게보다 작다면 해당 무게는 만들 수 없음을 의미한다
- 따라서 해당 수가 정답이다
- 합이 그 이전의 값을 만들 수 있다는 것을 보장한다는 것을 전제로한다 (왜 그런지 아무도 모르지만..)

Q) 왜 시작 합을 weight[0]으로 하면 안되는가
- weight[0]이 만약 1이라면 1을 만들 수 있다는 가정하에 시작하여 괜찮지만
- 만약 weight[0]이 1이 아니라면 1을 만들 수 없다는 것인데 해당 값을 계산하지 못한다
- 따라서 시작 합을 0으로 해야다ㄴ 
'''
