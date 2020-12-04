import sys


class Node:
    def __init__(self, char, depth=''):
        self.char = char
        self.depth = depth
        self.next = {}


root = Node(char=None)

n = int(sys.stdin.readline())
for _ in range(n):
    words = list(map(str, sys.stdin.readline().split()))[1:]
    depth = ''
    present_node = root
    for word in words:
        next_node = present_node.next.get(word)
        if next_node is None:
            next_node = Node(char=word, depth=depth)
            present_node.next[word] = next_node
        present_node = next_node
        depth = f'{depth}--'

stack = []
stack.append(root)

while stack:
    node = stack.pop()
    if node.char is not None:
        print(f'{node.depth}{node.char}')
    for next_node in sorted(node.next.keys(), reverse=True):
        stack.append(node.next[next_node])
