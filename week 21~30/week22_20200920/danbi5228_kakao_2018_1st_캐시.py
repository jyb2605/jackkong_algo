def solution(cacheSize, cities):
    answer = 0
    
    # cache = [[0 for x in range(2)] for y in range(cacheSize)]
    cache = {}
    idx = 0
    
    if cacheSize == 0:
        return len(cities)*5
    
    for city in cities:
        city = city.lower()
        if city in cache:
            answer += 1
        elif len(cache.keys()) < cacheSize:
            answer += 5
        else:
            least_v = sorted(list(cache.values()))[0]
            for c in cache:
                if cache[c] == least_v:
                    del cache[c]
                    break
            answer += 5
        cache[city] = idx
        idx+= 1
            
    return answer
