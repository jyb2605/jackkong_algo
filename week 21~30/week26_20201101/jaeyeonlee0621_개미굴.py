import sys


class Node:
    def __init__(self, char):
        self.char = char
        self.depth = ''
        self.next = {}

    def __repr__(self):
        return f'{self.depth}{self.char}'


roots = {}

n = int(sys.stdin.readline())
for _ in range(n):
    input = list(map(str, sys.stdin.readline().split()))

    root = roots.get(input[1])
    if root is None:
        root = Node(char=input[1])
        roots[input[1]] = root
    present_node = root

    depth = '--'
    for word in input[2:]:
        next_node = present_node.next.get(word)
        if next_node is None:
            next_node = Node(char=word)
            present_node.next[word] = next_node
        next_node.depth = depth
        present_node = next_node
        depth = f'{depth}--'
