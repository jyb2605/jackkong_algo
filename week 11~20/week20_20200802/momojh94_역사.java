/*
 * 2020-08-02
 * https://www.acmicpc.net/problem/1613
 * 플로이드 와샬
 * 
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] edges = new int[401][401];
        int a, b;
        int answer = 0;

        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
                edges[i][j] = INF;
            }
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a][b] = 1;
        }

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= v; j++) {
                    if(edges[i][j] > edges[i][k] + edges[k][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(INF == edges[a][b] && INF == edges[b][a]) {
                answer = 0;
            } else if (INF > edges[a][b]) {
                answer = -1;
            } else if (INF > edges[b][a]) {
                answer = 1;
            }
            bw.write(Integer.toString(answer));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}