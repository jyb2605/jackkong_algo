/*
 * 2020-08-02
 * https://www.acmicpc.net/problem/2606
 * 플로이드 와샬
 *
1 -> 6
15

1 -> 2 -> 7-> 6
   5    2    3

2를 중간점으로
1->7
7

1->6 > 1->7 + 7->6
inf	7	3

1-> 7 -> 2-> 6
  3      4     5
7->2->6

7->6
9

1->6 > 1->7 + 7->6
inf	3	9
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] edges = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                edges[i][j] = INF;
            }
        }

        int a, b;
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(edges[i][j] > edges[i][k] + edges[k][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                    }
                }
            }
        }

        for(int i = 2; i < n + 1; i++) {
            answer += edges[1][i] < INF ? 1 : 0;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}