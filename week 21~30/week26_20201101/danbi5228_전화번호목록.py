# 전화번호 목록

# 시간초과
# case_num = int(input())
#
#
# class Node:
#     def __init__(self, key):
#         self.key = key
#         self.child = {}
#
#
# class Trie:
#     def __init__(self):
#         self.head = Node(None)
#
#     def insert(self, word):
#         cur = self.head
#         for ch in word:
#             if ch not in cur.child:
#                 cur.child[ch] = Node(ch)
#             cur = cur.child[ch]
#         cur.child['*'] = True
#
#     def search(self, word):
#         cur = self.head
#
#         for ch in word:
#             if '*' in cur.child:
#                 return False
#             cur = cur.child[ch]
#         if '*' in cur.child:
#             return True
#         #     if ch not in cur.child:
#         #         return False
#         #     cur = cur.child[ch]
#         # if '*' in cur.child:
#         #     return True
#
#
# while case_num != 0:
#     input_num = int(input())
#     trie = Trie()
#     input_value = []
#     tf_value = []
#     is_False = False
#     for i in range(input_num):
#         tmp_input = input()
#         trie.insert(tmp_input)
#         input_value.append(tmp_input)
#
#     for i in input_value:
#         if trie.search(i) == False:
#             print('No')
#             is_False = True
#             break
#
#     case_num -= 1
#     if is_False:
#         continue
#     print('YES')
#     # print(trie.search('97625999'))
#     # print(trie.search('91125426'))
#     # print(trie.search('911'))


# 2

import sys
case_num = int(input())


class Node:
    def __init__(self, key):
        self.key = key
        self.child = {}
        # self.child = [None for _ in range(10)]
        self.is_terminal = False


class Trie:
    def __init__(self):
        # self.head = Node('')
        self.head = Node(None)

    def insert(self, word):
        cur = self.head
        for ch in word:
            # if cur.child[ch] is not None:
            #     cur = cur.child[ch]
            # else:
            #     new = Node(ch)
            #     cur.child[ch] = new
            #     cur = new
            if ch not in cur.child:
                cur.child[ch] = Node(ch)
            cur = cur.child[ch]
        cur.is_terminal = True

    def search(self, word):
        cur = self.head
        for j in range(len(word)):
            # print(cur.is_terminal)
            if cur.is_terminal:
                return False
            cur = cur.child[word[j]]
        return True


while case_num != 0:
    input_num = int(input())
    trie = Trie()
    input_value = []
    result = True
    for _ in range(input_num):
        # tmp_input = input()
        # tmp_input = list(map(int, input())) # 아래꺼보다 훨씬 느림ㅠ
        tmp_input = list(map(int, sys.stdin.readline().rstrip()))
        trie.insert(tmp_input)
        input_value.append(tmp_input)

    for i in input_value:
        result *= trie.search(i)

    if result:
        print('YES')
    else:
        print('NO')
    case_num -= 1
