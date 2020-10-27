/*
 * 2020-10-28
 * 레드 블루 스패닝 트리
 * https://www.acmicpc.net/problem/4792
 * MST
 * 
 * 해설보고 풀이
 * 스패닝트리 블루 최소 갯수 <= k <= 최대 갯수 이면 return 1 아니면 return 0
 * 
 * 첫 제출 때 틀렸는데 union 함수 잘 못 구현함.
 * public void union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if(x != y) {
            parents[y] = x;
        }
    }
 * parent[y] = x 로 해야되는데 y = x;로 해서 틀렸음.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        Solution s = new Solution();
        int answer = 0;
        String n;
        char c;
        int m, k, f, t;
        Edge[] edges;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = st.nextToken();
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n.equals("0")) {
                break;
            } else {
                edges = new Edge[m];
                for(int idx = 0; idx < m; idx++) {
                    st = new StringTokenizer(br.readLine());
                    c = st.nextToken().charAt(0);
                    f = Integer.parseInt(st.nextToken());
                    t = Integer.parseInt(st.nextToken());
                    edges[idx] = new Edge(f, t, (c =='R') ? 0 : 1);
                }
                answer = s.solution(edges, Integer.parseInt(n), k);
                bw.write(Integer.toString(answer));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}

class Edge {
    int node1;
    int node2;
    int color;

    public Edge(int node1, int node2, int color) {
        this.node1 = node1;
        this.node2 = node2;
        this.color = color;
    }
}

class Solution {
    public int solution(Edge[] edges, int n, int k) {
        int ret = 0;
        int redPriorityBlueEdgesCnt = 0;
        int bluePriorityBlueEdgesCnt = 0;

        // Red 우선
        Arrays.sort(edges, (o1, o2) -> o1.color - o2.color);
        int[] parents = new int[n + 1];
        for(int idx = 1; idx < n + 1; idx++) {
            parents[idx] = idx;
        }
        int treeCnt = 0;
        for(Edge e : edges) {
            if(treeCnt >= n - 1) break;
            if(find(parents, e.node1) != find(parents, e.node2)) {
                union(parents, e.node1, e.node2);
                treeCnt++;
                if(e.color == 1) {
                    redPriorityBlueEdgesCnt++;
                }
            }
        }

        // Blue 우선
        Arrays.sort(edges, (o1, o2) -> o2.color - o1.color);
        for(int idx = 1; idx < n + 1; idx++) {
            parents[idx] = idx;
        }
        treeCnt = 0;
        for(Edge e : edges) {
            if(treeCnt >= n - 1) break;
            if(find(parents, e.node1) != find(parents, e.node2)) {
                union(parents, e.node1, e.node2);
                treeCnt++;
                if(e.color == 1) {
                    bluePriorityBlueEdgesCnt++;
                }
            }
        }

        ret = (redPriorityBlueEdgesCnt <= k && k <= bluePriorityBlueEdgesCnt)
                ? 1
                : 0;
        return ret;
    }

    public void union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if(x != y) {
            parents[y] = x;
        }
    }

    public int find(int[] parents, int x) {
        if(x == parents[x]) {
            return x;
        }

        int p = find(parents, parents[x]);
        parents[x] = p;
        return p;
    }
}
