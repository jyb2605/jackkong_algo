/*
 * 2020-09-24
 * https://www.acmicpc.net/problem/6497
 * 6497 전력난
 *
 * mst - kruskal로 해결
 * mst를 구하고 모든 길의 cost 합 - mst내의 모든 길 cost 합 출력
 *
 * 기존 백준 문제와 다르게 입력이 한꺼 번에 여러 번 들어오는 형태라 주의 - 이 것 때문에 틀렸음
 * https://www.acmicpc.net/board/view/54358
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

class Edge implements Comparable<Edge>{
    int[] node;
    int cost;

    public Edge(int node1, int node2, int cost) {
        this.node = new int[]{node1, node2};
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

        while(true){
            StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (v == 0 && e == 0) {
                bw.close();
                return;
            }
            int x, y, z;

            if(v <= 2) {
                bw.write("0");
                bw.newLine();
                bw.flush();
                bw.close();
                return;
            }

            int answer = 0;
            int edgesCostTotal = 0;
            int selectedEdgesCnt = 0;
            int selectedEdgesCostTotal = 0;

            int[] parents = new int[v];
            List<Edge> edges = new LinkedList<>();

            for(int i = 0; i < v; i++) {
                parents[i] = i;
            }

            for(int i = 0 ; i < e; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                z = Integer.parseInt(st.nextToken());
                edgesCostTotal += z;
                edges.add(new Edge(x, y, z));
            }
            Collections.sort(edges);

            for(Edge edge : edges) {
                if(selectedEdgesCnt >= v - 1) break;
                if(find(parents, edge.node[0]) != find(parents, edge.node[1])) {
                    selectedEdgesCostTotal += edge.cost;
                    union(parents, edge.node[0], edge.node[1]);
                    selectedEdgesCnt++;
                }
            }

            answer = edgesCostTotal - selectedEdgesCostTotal;
            bw.write(Integer.toString(answer));
            bw.newLine();
            bw.flush();
        }
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