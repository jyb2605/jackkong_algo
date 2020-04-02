def solution(array, commands):
    answer = []
    for command in commands:
        parts = array[command[0] - 1:command[1]]
        parts.sort()
        answer.append(parts[command[2] - 1])
    return answer