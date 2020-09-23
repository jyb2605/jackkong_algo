/*
 * 2020-09-24
 * https://www.acmicpc.net/problem/1647
 * 1647번 도시 분할 계획
 *
 * 메모리 322064 KB
 * 시간 1808 ms
 *
 * mst - kruskal로 해결
 * mst를 구하고 mst내의 모든 길의 유지비 중 cost가 가장 큰 길의 유지비만 뺀 값 출력
 */

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

class Edge implements Comparable<Edge>{
    int node1;
    int node2;
    int cost;

    public Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, c;

        int answer = 0;
        int selectedEdgesCnt = 0;
        int costMax = -1;
        int[] parents = new int[n+1];
        List<Edge> edges = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges);

        for(Edge edge : edges) {
            if(selectedEdgesCnt >= n - 1) break;
            if(find(parents, edge.node1) != find(parents, edge.node2)) {
                if(costMax < edge.cost) {
                    costMax = edge.cost;
                }
                answer += edge.cost;
                union(parents, edge.node1, edge.node2);
                selectedEdgesCnt++;
            }
        }

        bw.write(Integer.toString(answer - costMax));
        bw.newLine();
        bw.flush();
        bw.close();
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