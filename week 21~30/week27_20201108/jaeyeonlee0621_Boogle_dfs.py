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

        for location in locations:
            if is_find:
                break

            stack = [(location[0], location[1], 0)]
            visited = [[0 for _ in range(4)] for _ in range(4)]

            while stack:
                y, x, w = stack.pop()

                is_find = (w == len(word) - 1)
                if is_find:
                    break
                if visited[y][x] == 1:
                    continue
                visited[y][x] = 1

                for y_move, x_move in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                    y_, x_ = y + y_move, x + x_move
                    if 0 <= y_ < 4 and 0 <= x_ < 4 and word[w + 1] == boards[y_][x_]:
                        stack.append((y_, x_, w + 1))

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

            if len(longest_word) < len(word) or (len(longest_word) == len(word) and longest_word > word):
                longest_word = word

    print(f'{total_point} {longest_word} {total_count}')
