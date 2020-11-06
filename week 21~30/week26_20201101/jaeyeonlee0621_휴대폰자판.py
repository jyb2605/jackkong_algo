import sys


class Node:
    def __init__(self, char):
        self.char = char
        self.ref = 1
        self.next = []

    def __repr__(self):
        return f'char: {self.char}, ref: {self.ref}'


while True:
    n = int(sys.stdin.readline())

    words = [str(sys.stdin.readline().strip()) for _ in range(n)]
    roots = []

    # make tree
    for word in words:
        root_node = None
        for root in roots:
            if root.char == word[0]:
                root_node = root
                root_node.ref += 1
                break
        if root_node is None:
            root_node = Node(char=word[0])
            roots.append(root_node)

        present_node = root_node
        for i in range(1, len(word)):
            next_node = None
            for node in present_node.next:
                if node.char == word[i]:
                    node.ref += 1
                    next_node = node
                    break
            if next_node is None:
                next_node = Node(char=word[i])
                present_node.next.append(next_node)
            present_node = next_node

    answer = 0
    for word in words:
        count = 1

        root_node = None
        for root in roots:
            if root.char == word[0]:
                root_node = root
                break

        present_node = root_node
        present_ref = present_node.ref
        for i in range(1, len(word)):
            for next_node in present_node.next:
                if next_node.char == word[i]:
                    if present_ref != next_node.ref:
                        count += 1
                    present_node = next_node
                    present_ref = present_node.ref
                    break
        answer += count

    print(round(answer / len(words), 2))
