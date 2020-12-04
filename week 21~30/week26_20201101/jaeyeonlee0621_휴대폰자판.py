import sys


class Node:
    def __init__(self, char):
        self.char = char
        self.ref = 1
        self.next = {}

    def __repr__(self):
        return f'char: {self.char}, ref: {self.ref}'


while True:
    try:
        n = int(sys.stdin.readline())
    except:
        break

    words = [str(sys.stdin.readline().strip()) for _ in range(n)]
    roots = {}

    # make tree
    for word in words:
        root_node = roots.get(word[0])
        if not root_node:
            root_node = Node(char=word[0])
            roots[word[0]] = root_node
        else:
            root_node.ref += 1

        present_node = root_node
        for i in range(1, len(word)):
            next_node = present_node.next.get(word[i])
            if not next_node:
                next_node = Node(char=word[i])
            else:
                next_node.ref += 1
            present_node.next[word[i]] = next_node
            present_node = next_node

    answer = 0
    for word in words:
        count = 1

        present_node = roots.get(word[0])
        present_ref = present_node.ref

        for i in range(1, len(word)):
            next_node = present_node.next[word[i]]
            if present_ref != next_node.ref:
                count += 1
            present_node = next_node
            present_ref = present_node.ref

        answer += count

    print(round(answer / len(words), 2))
