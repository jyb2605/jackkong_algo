import sys

n = int(sys.stdin.readline().strip())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

white, blue = 0, 0
length = 8

while length > 1:
    paper_ = []
    for y in range(0, length, 2):
        line = []
        for x in range(0, length, 2):
            if paper[y][x] == paper[y][x + 1] == paper[y + 1][x + 1]:
                line.append(paper[y][x])

            else:
                line.append(-1)

                if paper[y][x] == 1:
                    blue += 1
                if paper[y][x] == 0:
                    white += 1

                if paper[y][x + 1] == 1:
                    blue += 1
                if paper[y][x + 1] == 0:
                    white += 1

                if paper[y + 1][x] == 1:
                    blue += 1
                if paper[y + 1][x] == 0:
                    white += 1

                if paper[y + 1][x + 1] == 1:
                    blue += 1
                if paper[y + 1][x + 1] == 0:
                    white += 1

        paper_.append(line)

    paper = paper_
    length //= 2

if paper[0][0] == 1:
    blue += 1
if paper[0][0] == 0:
    white += 1

print(white)
print(blue)
