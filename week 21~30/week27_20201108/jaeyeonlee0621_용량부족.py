import sys


class Node:
    def __init__(self, char, is_final=False, can_delete=True):
        self.char = char
        self.is_final = is_final
        self.can_delete = can_delete
        self.next = {}
        self.is_visited = False

    def __repr__(self):
        return f'[{self.char}] is_final: {self.is_final} can_delete: {self.can_delete}'


n = int(sys.stdin.readline())
for _ in range(n):

    root = Node(char=None, can_delete=False)

    can_delete_word_count = int(sys.stdin.readline())
    for _ in range(can_delete_word_count):
        can_delete_word = str(sys.stdin.readline().strip())
        present_node = root
        for character in can_delete_word:
            if not present_node.next.get(character):
                present_node.next[character] = Node(char=character)
            present_node = present_node.next[character]
        present_node.is_final = True

    can_not_delete_word_count = int(sys.stdin.readline())
    for _ in range(can_not_delete_word_count):
        can_not_delete_word = str(sys.stdin.readline().strip())
        present_node = root
        for character in can_not_delete_word:
            if not present_node.next.get(character):
                present_node.next[character] = Node(char=character, can_delete=False)
            present_node.can_delete = False
            present_node = present_node.next[character]
        present_node.can_delete = False

    if not can_not_delete_word_count:
        root.can_delete = True

    answer, stack = 0, [root]
    while stack:
        node = stack.pop()
        if node.is_visited:
            continue
        node.is_visited = True
        if node.is_final or node.can_delete:
            answer += 1
        if not node.can_delete:
            for next_node_key in node.next.keys():
                stack.append(node.next[next_node_key])

    print(answer)
