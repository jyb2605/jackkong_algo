def solution(arrangement):
    answer = 0
    stack_ = []
    for i in range(len(arrangement)):
        if arrangement[i] == '(': stack_.append([i, 0])
        if arrangement[i] == ')':
            if i - stack_[-1][0] == 1:
                stack_.pop()
                if len(stack_): stack_[-1][1] += 1
            else:
                _, count = stack_.pop()
                answer += count + 1
                if len(stack_): stack_[-1][1] += count
    return answer


print(solution('()(((()())(())()))(())'))

'''
def solution(arrangement):
    answer = 0
    sticks = 0
    rasor_to_zero = arrangement.replace('()','0')
    for i in rasor_to_zero:
        if i == '(': sticks += 1
        elif i =='0' : answer += sticks
        else :
            sticks -= 1
            answer += 1
    return answer
'''