import sys

word_count = int(sys.stdin.readline())
words = [str(sys.stdin.readline().strip()) for _ in range(word_count)]
sys.stdin.readline()

board_count = int(sys.stdin.readline())
for i in range(board_count):
    total_point = 0
    longest_word = ''
    total_count = 0

    boards = [str(sys.stdin.readline().strip()) for _ in range(4)]
    if i != board_count - 1:
        sys.stdin.readline()

    keywords = {}
    for y in range(4):
        for x in range(4):
            if not keywords.get(boards[y][x]):
                keywords[boards[y][x]] = []
            keywords[boards[y][x]].append((y, x))

    for word in words:
        is_find = False

        locations = keywords.get(word[0])
        if locations is None:
            continue

        stack = [(location[0], location[1], 0) for location in locations]

        while stack:
            is_find_word = False
            y, x, w = stack.pop()

            if w + 1 == len(word) - 1:
                is_find = True
                break

            if y - 1 >= 0 and boards[y - 1][x] == word[w + 1]:
                stack.append((y - 1, x, w + 1))
                is_find_word = True
            if x - 1 >= 0 and boards[y][x - 1] == word[w + 1]:
                stack.append((y, x - 1, w + 1))
                is_find_word = True
            if y + 1 < 4 and boards[y + 1][x] == word[w + 1]:
                stack.append((y + 1, x, w + 1))
                is_find_word = True
            if x + 1 < 4 and boards[y][x + 1] == word[w + 1]:
                stack.append((y, x + 1, w + 1))
                is_find_word = True
            if y - 1 >= 0 and x - 1 >= 0 and boards[y - 1][x - 1] == word[w + 1]:
                stack.append((y - 1, x - 1, w + 1))
                is_find_word = True
            if y - 1 >= 0 and x + 1 < 4 and boards[y - 1][x + 1] == word[w + 1]:
                stack.append((y - 1, x + 1, w + 1))
                is_find_word = True
            if y + 1 < 4 and x - 1 >= 0 and boards[y + 1][x - 1] == word[w + 1]:
                stack.append((y + 1, x - 1, w + 1))
                is_find_word = True
            if y + 1 < 4 and x + 1 < 4 and boards[y + 1][x + 1] == word[w + 1]:
                stack.append((y + 1, x + 1, w + 1))
                is_find_word = True

            if not is_find_word:
                break

        if is_find:
            total_count += 1

            len_word = len(word)
            if 3 <= len_word <= 4:
                total_point += 1
            if len_word == 5:
                total_point += 2
            if len_word == 6:
                total_point += 3
            if len_word == 7:
                total_point += 5
            if len_word == 8:
                total_point += 11

            if len(longest_word) < len(word):
                longest_word = word
            elif len(longest_word) == len(word) and longest_word[0] > word[0]:
                longest_word = word

    print(f'{total_point} {longest_word} {total_count}')
