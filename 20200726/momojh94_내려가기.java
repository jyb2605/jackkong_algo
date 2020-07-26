/*
 * 2020-07-26
 * https://www.acmicpc.net/problem/2096
 * 백준 dp
 *
 * 주어진 조건을 만족하며 각 줄에 max와 min값 dp로 구하여 출력하면 된다.
 * 다음 줄로 내려갈 때 바로 아래의 수나 바로 아래의 수와 붙어 있는 수로만 이동하는
 * 조건에 유의하여 값을 비교하면 된다.
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int max;
        int min;
        int[][] line = new int[100001][3];
        int[][] dpMax = new int[100001][3];
        int[][] dpMin = new int[100001][3];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                line[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n+1; i++){
            dpMax[i][0] = Math.max(dpMax[i-1][0] + line[i-1][0], dpMax[i-1][1] + line[i-1][1]);
            dpMax[i][1] = Math.max(dpMax[i-1][0] + line[i-1][0], dpMax[i-1][1] + line[i-1][1]);
            dpMax[i][1] = Math.max(dpMax[i][1], dpMax[i-1][2] + line[i-1][2]);
            dpMax[i][2] = Math.max(dpMax[i-1][1] + line[i-1][1], dpMax[i-1][2] + line[i-1][2]);

            dpMin[i][0] = Math.min(dpMin[i-1][0] + line[i-1][0], dpMin[i-1][1] + line[i-1][1]);
            dpMin[i][1] = Math.min(dpMin[i-1][0] + line[i-1][0], dpMin[i-1][1] + line[i-1][1]);
            dpMin[i][1] = Math.min(dpMin[i][1], dpMin[i-1][2] + line[i-1][2]);
            dpMin[i][2] = Math.min(dpMin[i-1][1] + line[i-1][1], dpMin[i-1][2] + line[i-1][2]);
        }

        max = Math.max(dpMax[n][0], dpMax[n][1]);
        max = Math.max(max, dpMax[n][2]);
        min = Math.min(dpMin[n][0], dpMin[n][1]);
        min = Math.min(min, dpMin[n][2]);

        bw.write(Integer.toString(max) + " " + Integer.toString(min));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}