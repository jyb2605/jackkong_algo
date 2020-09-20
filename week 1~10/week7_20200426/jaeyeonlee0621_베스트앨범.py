def solution(genres, plays):
    answer = []
    sum_ = {}
    play = {}
    for i in range(len(genres)):
        genre = genres[i]
        if sum_.get(genre): sum_[genre] += plays[i]
        else: sum_[genre] = plays[i]
        if play.get(genre): play[genre].append((plays[i], i))
        else: play[genre] = [(plays[i], i)]
    sum_ = sorted(sum_.items(), key=lambda x: x[1], reverse=True)
    for genre, _ in sum_:
        play[genre].sort(key=lambda x: x[0], reverse=True)
        for i in range(len(play[genre])):
            if i >= 2: break
            answer.append(play[genre][i][1])
    return answer


print(solution(["classic", "pop", "classic", "classic", "pop"], [800, 600, 150, 800, 2500])) # 4 1 3 0
print(solution(['classic', 'pop', 'classic', 'classic', 'pop'], [500, 600, 501, 800, 900])) # 3 2 4 1
