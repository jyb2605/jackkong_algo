def solution(cacheSize, cities):
    answer = 0
    cache = {}
    if cacheSize == 0:
        return len(cities) * 5
    for i in range(len(cities)):
        city = cities[i].lower()
        if cache.get(city) is not None:
            answer += 1
        else:
            answer += 5
            if len(cache) == cacheSize:
                pop_city = sorted(cache.items(), key=lambda x: x[1])[0][0]
                cache.pop(pop_city)
        cache[city] = i
    return answer


print(solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
print(solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]))
print(solution(3, ["Jeju", "Pangyo", "Jeju", "Jeju"]))
print(solution(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                   "NewYork", "Rome"]))
print(solution(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                   "NewYork", "Rome"]))
print(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]))
print(solution(0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
