import sys


def search(y, x, node):
    next_node = node.next.get(boards[y][x])
    stack = [] if not next_node else [(y, x, next_node, boards[y][x])]
    answer = []

    visited = [[0 for _ in range(4)] for _ in range(4)]
    while stack:
        y, x, node, word = stack.pop()

        if words.get(word):
            answer.append(word)

        if visited[y][x] == 1:
            continue

        visited[y][x] = 1

        if y - 1 >= 0 and node.next.get(boards[y - 1][x]):
            stack.append((y - 1, x, node.next.get(boards[y - 1][x]), word + boards[y - 1][x]))

        if x - 1 >= 0 and node.next.get(boards[y][x - 1]):
            stack.append((y, x - 1, node.next.get(boards[y][x - 1]), word + boards[y][x - 1]))

        if y + 1 < 4 and node.next.get(boards[y + 1][x]):
            stack.append((y + 1, x, node.next.get(boards[y + 1][x]), word + boards[y + 1][x]))

        if x + 1 < 4 and node.next.get(boards[y][x + 1]):
            stack.append((y, x + 1, node.next.get(boards[y][x + 1]), word + boards[y][x + 1]))

        if y - 1 >= 0 and x - 1 >= 0 and node.next.get(boards[y - 1][x - 1]):
            stack.append((y - 1, x - 1, node.next.get(boards[y - 1][x - 1]), word + boards[y - 1][x - 1]))

        if y - 1 >= 0 and x + 1 < 4 and node.next.get(boards[y - 1][x + 1]):
            stack.append((y - 1, x + 1, node.next.get(boards[y - 1][x + 1]), word + boards[y - 1][x + 1]))

        if y + 1 < 4 and x - 1 >= 0 and node.next.get(boards[y + 1][x - 1]):
            stack.append((y + 1, x - 1, node.next.get(boards[y + 1][x - 1]), word + boards[y + 1][x - 1]))

        if y + 1 < 4 and x + 1 < 4 and node.next.get(boards[y + 1][x + 1]):
            stack.append((y + 1, x + 1, node.next.get(boards[y + 1][x + 1]), word + boards[y + 1][x + 1]))

    return answer


class Node:
    def __init__(self, char):
        self.char = char
        self.next = {}

    def __repr__(self):
        return f'{self.char} {self.next}'


word_count = int(sys.stdin.readline())
words = {}
for _ in range(word_count):
    words[str(sys.stdin.readline().strip())] = 1
sys.stdin.readline()

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

    boards = [str(sys.stdin.readline().strip()) for _ in range(4)]
    if i != board_count - 1:
        sys.stdin.readline()

    for y in range(4):
        for x in range(4):
            answer = search(y, x, root_node)

            for word in answer:
                if find_word.get(word):
                    continue

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

                if len(answers[1]) < len(word) or (len(answers[1]) == len(word) and answers[1][0] > word[0]):
                    answers[1] = word

    print(f'{answers[0]} {answers[1]} {answers[2]}')
