/*
 * 2020-08-15
 * https://www.acmicpc.net/problem/1238
 * 플로이드 와샬
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] edges = new int[1003][1003];
        int max = -1;
        int a, b, t;
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                edges[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            edges[a][b] = t;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) continue;
                    if(edges[i][j] > edges[i][k] + edges[k][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                    }
                }
            }
        }

        int potentialNum;
        for(int i = 1; i <= n; i++) {
            if(i == x) continue;;
            potentialNum = edges[i][x] + edges[x][i];
            if(potentialNum > max) {
                max = potentialNum;
            }
        }
        answer = max;
        bw.write(Integer.toString(answer));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}