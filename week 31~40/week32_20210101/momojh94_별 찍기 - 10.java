/*
 * 2021-01-01
 * 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 * 분할 정복
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer[] sbLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        sbLine = new StringBuffer[n];
        for(int idx = 0; idx < n; idx++) {
            sbLine[idx] = new StringBuffer();
        }

        star(n,0, true);
        for(int idx = 0; idx < n; idx++) {
            bw.write(sbLine[idx].toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public static void star(int n, int y, boolean canWrite) throws IOException {
        if(n == 3) {
            if(canWrite) {
                sbLine[y].append("***");
                sbLine[y + 1].append("* *");
                sbLine[y + 2].append("***");
            } else {
                sbLine[y].append("   ");
                sbLine[y + 1].append("   ");
                sbLine[y + 2].append("   ");
            }
            return;
        }

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                if((row == 1 && col == 1) || !canWrite) {
                    star(n / 3, y + row * (n / 3), false);
                    continue;
                }
                star(n / 3,y + row * (n / 3), true);
            }
        }
    }
}