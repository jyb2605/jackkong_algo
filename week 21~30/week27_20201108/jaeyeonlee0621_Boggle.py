import sys


class Node:
    def __init__(self, char):
        self.char = char
        self.next = {}
        self.is_final = False

    def __repr__(self):
        return f'{self.char} {self.next} {self.is_final}'


def dfs(y, x, word, visited, node):
    if node.is_final:
        answer[word] = 1
    if len(word) == 8:
        return
    for x_move, y_move in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
        y_, x_ = y + y_move, x + x_move
        if 0 <= x_ < 4 and 0 <= y_ < 4 and not visited[y_][x_] and node.next.get(boards[y_][x_]):
            visited[y_][x_] = 1
            dfs(y_, x_, word + boards[y_][x_], visited, node.next.get(boards[y_][x_]))
            visited[y_][x_] = 0


# word 입력
word_count = int(sys.stdin.readline())
words = {}
for _ in range(word_count):
    words[str(sys.stdin.readline().strip())] = 1
sys.stdin.readline()

# tree 만들기
root_node = Node(char=None)
for word in words.keys():
    present_node = root_node
    for character in word:
        if present_node.next.get(character) is None:
            present_node.next[character] = Node(char=character)
        present_node = present_node.next[character]
    present_node.is_final = True

board_count = int(sys.stdin.readline())
for i in range(board_count):
    point, longest_word, count = 0, '', 0
    answer = {}

    # board 입력
    boards = [str(sys.stdin.readline().strip()) for _ in range(4)]
    if i != board_count - 1:
        sys.stdin.readline()

    # dfs
    visited = [[0 for _ in range(4)] for _ in range(4)]
    for y in range(4):
        for x in range(4):
            if not root_node.next.get(boards[y][x]):
                continue
            visited[y][x] = 1
            dfs(y, x, boards[y][x], visited, root_node.next[boards[y][x]])
            visited[y][x] = 0

    # 점수 계산
    score = {3: 1, 4: 1, 5: 2, 6: 3, 7: 5, 8: 11}
    for word in answer.keys():
        count += 1
        if score.get(len(word)):
            point += score[len(word)]
        if len(longest_word) < len(word) or (len(longest_word) == len(word) and longest_word > word):
            longest_word = word

    print(f'{point} {longest_word} {count}')
