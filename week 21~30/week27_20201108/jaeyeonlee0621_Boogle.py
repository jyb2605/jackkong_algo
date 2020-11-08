import sys


class Node:
    def __init__(self, char):
        self.char = char
        self.next = {}

    def __repr__(self):
        return f'{self.char} {self.next}'


def search(y, x, node, word, visited):
    if word and words.get(word):
        answer.append(word)
    if visited[y][x] == 1:
        return
    visited[y][x] = 1
    for x_move, y_move in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
        y_, x_ = y + y_move, x + x_move
        if 0 <= x_ < 4 and 0 <= y_ < 4 and node.next.get(boards[y_][x_]):
            search(y_, x_, node.next.get(boards[y_][x_]), word + boards[y_][x_], visited)
    visited[y][x] = 0


# word 입력
word_count = int(sys.stdin.readline())
words = {}
for _ in range(word_count):
    words[str(sys.stdin.readline().strip())] = 1
sys.stdin.readline()

# tree 만들기
root_node = Node(char=None)
for word in words:
    present_node = root_node
    for character in word:
        if present_node.next.get(character) is None:
            present_node.next[character] = Node(char=character)
        present_node = present_node.next[character]

board_count = int(sys.stdin.readline())
for i in range(board_count):
    answers = [0, '', 0]
    find_word = {}

    # board 입력
    boards = [str(sys.stdin.readline().strip()) for _ in range(4)]
    if i != board_count - 1:
        sys.stdin.readline()

    for y in range(4):
        for x in range(4):
            node = root_node.next.get(boards[y][x])
            if not node:
                continue

            # search
            answer = []
            visited = [[0 for _ in range(4)] for _ in range(4)]

            search(y, x, node, boards[y][x], visited)
            for word in answer:
                if not find_word.get(word[0]):
                    find_word[word[0]] = []
                if word in find_word[word[0]]:
                    continue
                find_word[word[0]].append(word)

                find_word[word] = 1
                answers[2] += 1

                len_word = len(word)
                if 3 <= len_word <= 4:
                    answers[0] += 1
                elif len_word == 5:
                    answers[0] += 2
                elif len_word == 6:
                    answers[0] += 3
                elif len_word == 7:
                    answers[0] += 5
                elif len_word == 8:
                    answers[0] += 11

                if len(answers[1]) < len(word) or (len(answers[1]) == len(word) and answers[1] > word):
                    answers[1] = word

    print(f'{answers[0]} {answers[1]} {answers[2]}')
