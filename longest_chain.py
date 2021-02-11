import re


def longestChain(words):
    depths = [1 for _ in range(len(words))]
    visited = [{} for _ in range(len(words))]

    words.sort()
    for i in range(len(words) - 2, -1, -1):
        count, index = 0, i
        word = '(\w*)' + '(\w*)'.join(words[i]) + '(\w*)'
        for j in range(i + 1, len(words)):
            if visited[index].get(j):
                continue
            if re.match(rf"^{words[i]}+$", words[j]) or re.match(rf"^{word}+$", words[j]):
                count = max(count, depths[j])
                index = j
                if not visited[i].get(j):
                    visited[i][j] = 1
        depths[i] += count
    return max(depths)


words = ['aaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaa',
         'aaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaa',
         'aaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaa',
         'aaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aa',
         'aaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'a',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
         'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa']
