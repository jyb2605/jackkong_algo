def solution(routes):
    answer = 1
    routes.sort()
    camera = routes[0][1]
    for i in range(1, len(routes)):
        if camera < routes[i][0]:
            answer += 1
            camera = routes[i][1]
        if camera >= routes[i][0] and camera >= routes[i][1]:
            camera = routes[i][1]
    return answer


'''
- 현재 카메라는 마지막으로 통과한 시간대에 둔다
- 만약 카메라의 위치보다 현재 차의 진입과 나가는 지점이 작다면 카메라를 해당 차의 나가는 지점에 놓는다
- 만약에 진입점이 카메라가 있는 위치보다 크다면 새로운 카메라를 둔다
'''

print(solution([[-2,-1], [1,2],[-3,0]]) == 2) #2
print(solution([[0,0],]) == 1) #1
print(solution([[0,1], [0,1], [1,2]]) == 1) #1
print(solution([[0,1], [2,3], [4,5], [6,7]]) == 4) #4
print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]) == 2) #2
print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]]) == 2) #2
print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]]) == 2) #2
print(solution([[-7,0], [-6,-4], [-5,-3], [-3,-1], [-1,4], [1,2], [3,4]]) == 4)  #4
print(solution([[-5,-3], [-4,0], [-4,-2], [-1, 2], [0,3], [1,5], [2,4] ]) == 2) #2
print(solution([[0,1], [1,2], [2,3] ,[3,4], [5,4], [5,6], [6,7] , [8,7], [8,9] ,[9,10], [10,11], [11,12], [12,13], [13,14]]) == 8)
