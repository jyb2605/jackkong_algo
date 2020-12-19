/*
 * 2020-12-19
 * 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 * 분할 정복
 *
 * 해설 참조하여 해결...
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    private final static char WHITE = '0';
    private final static char BLUE = '1';
    private static char[][] coloredPapers;
    private static int whitePapersCnt = 0;
    private static int bluePapersCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        coloredPapers = new char[n][n];
        whitePapersCnt = 0;
        bluePapersCnt = 0;
        for(int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col++) {
                coloredPapers[row][col] = st.nextToken().charAt(0);
            }
        }
        cutPapers(n, 0, 0);

        bw.write(Integer.toString(whitePapersCnt));
        bw.newLine();
        bw.write(Integer.toString(bluePapersCnt));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    public static void cutPapers(int n, int x, int y) {
        char color = coloredPapers[y][x];
        int half = n / 2;
        if(isSameColor(half, x, y, color)) {
            if (color == BLUE) bluePapersCnt++;
            else whitePapersCnt++;
            return;
        }
        cutPapers(half, x, y);
        cutPapers(half, x + half, y);
        cutPapers(half, x, y + half);
        cutPapers(half, x + half, y + half);
    }

    public static boolean isSameColor(int half, int x, int y, char color) {
        for(int row = y; row < y + half; row++) {
            for(int col = x; col < x + half; col++) {
                if(coloredPapers[row][col] != color || coloredPapers[row][col + half] != color
                || coloredPapers[row + half][col] != color || coloredPapers[row + half][col + half] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}