def solution(bridge_length, weight, truck_weights):
    queue = [[truck_weights[0], 1], ]
    cur_weight = truck_weights.pop(0)
    time = 1
    while len(queue):
        i = 0
        while i < len(queue):
            queue[i][1] += 1
            if queue[i][1] > bridge_length: cur_weight -= queue.pop(0)[0]
            else: i+=1
        if len(truck_weights) and truck_weights[0] + cur_weight <= weight:
            cur_weight += truck_weights[0]
            queue.append([truck_weights.pop(0), 1])
        time += 1
    return time


print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))