from collections import deque


def solution(m, n, board):
    for i in range(m):
        board[i] = list(board[i])

    existed = True
    while existed:
        existed = False

        for x in range(m - 1):
            for y in range(n - 1):
                if board[x][y] == 0:
                    continue

                if board[x][y] == board[x + 1][y] == board[x][y + 1] == board[x + 1][y + 1]:
                    existed = True
                    board[x][y] = 0

                    queue = deque([])
                    queue.append((x + 1, y))
                    queue.append((x, y + 1))
                    queue.append((x + 1, y + 1))

                    while queue:
                        _x, _y = queue.popleft()
                        if _x == m - 1 or _y == n - 1:
                            board[_x][_y] = 0
                            continue
                        if board[_x][_y] == board[_x + 1][_y] == board[_x][_y + 1] == board[_x + 1][_y + 1]:
                            queue.append((_x + 1, _y))
                            queue.append((_x, _y + 1))
                            queue.append((_x + 1, _y + 1))
                        board[_x][_y] = 0

        for x in range(m - 1, -1, -1):
            for y in range(n):
                if board[x][y] == 0:
                    _x = x
                    while _x > 0:
                        if board[_x][y] != 0:
                            break
                        _x -= 1
                    board[x][y], board[_x][y] = board[_x][y], board[x][y]

    answer = 0
    for y in range(n):
        for x in range(m):
            if board[x][y] == 0:
                answer += 1

    return answer


print(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]))
print(solution(6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))
print(solution(5, 6, ["AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"]))
