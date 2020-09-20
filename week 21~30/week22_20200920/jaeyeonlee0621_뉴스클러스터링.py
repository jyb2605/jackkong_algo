def solution(str1, str2):
    str1_words = divide_word(str1)
    str2_words = divide_word(str2)

    sum_ = 0
    for key in str1_words.keys():
        sum_ += max(str1_words[key], str2_words.get(key, 0))
    for key in str2_words.keys():
        if not str1_words.get(key): sum_ += str2_words[key]

    and_ = 0
    for key in str1_words.keys():
        and_ += min(str1_words[key], str2_words.get(key, 0))

    return int((1 if not sum_ and not and_ else (and_ / sum_)) * 65536)


def divide_word(str1):
    answer = {}
    for i in range(len(str1) - 1):
        word = str1[i: i + 2].lower()
        if word.isalpha():
            if answer.get(word): answer[word] += 1
            else: answer[word] = 1
    return answer


print(solution('FRANCE', 'french'))
print(solution('handshake', 'shake hands'))
print(solution('aa1+aa2', 'AAAA12'))
print(solution('E=M*C^2', 'e=m*c^2'))
