/*
 * 2020-08-02
 * https://www.acmicpc.net/problem/1389
 * 플로이드 와샬
 *
 */

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] edges = new int[101][101];
        int[] kevinBacon = new int[101];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
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

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= v; j++) {
                    if(edges[i][j] > edges[i][k] + edges[k][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
                kevinBacon[i] += edges[i][j] < INF ? edges[i][j] : 0;
            }
        }

        int min = INF;

        for(int i = 1; i <= v; i++) {
            if(kevinBacon[i] < min) {
                pq.clear();
                pq.add(i);
                min = kevinBacon[i];
            } else if (kevinBacon[i] == min){
                pq.add(i);
            }
        }
        bw.write(Integer.toString(pq.poll()));
        bw.flush();
        bw.close();
    }
}