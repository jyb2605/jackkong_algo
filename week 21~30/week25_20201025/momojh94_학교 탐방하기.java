/*
 * 2020-10-25
 * 학교 탐방하기
 * https://www.acmicpc.net/problem/13418
 * MST
 * 
 * 오르막길 우선 스패닝 트리 구하고 오르막길 갯수 ^ 2에서
 * 내리막길 우선 스패닝 트리에서 구한 오르막길갯수 ^2 빼줘서 답 구하기
 * 
 * max * max - min * min 해야되는데
 * max * max - min 해서 계속 틀렸음
 */

package com.company;

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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, c;

        Edge[] edges = new Edge[m + 1];
        for (int idx = 0; idx < m + 1; idx++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges[idx] = new Edge(a, b, c);
        }
        answer = s.solution(n, m, edges);
        bw.write(Integer.toString(answer));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}


class Edge {
    int[] node;
    int cost;
    public Edge(int a, int b, int c) {
        this.node = new int[]{a, b};
        this.cost = c;
    }
}

// 0 오르막길
// 1 내리막길

class Solution {
    public int solution(int n, int m, Edge[] edges) {
        int answer = 0;
        int max = 0;
        int min = 0;

        Comparator<Edge> uphillPriorityComp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        };

        Comparator<Edge> downhillPriorityComp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.cost - o1.cost;
            }
        };

        Edge[] sortedEdges = new Edge[edges.length];
        int[] parents = new int[n + 1];

        // 오르막길 우선
        for(int idx = 0; idx < edges.length; idx++) {
            sortedEdges[idx] = edges[idx];
        }
        Arrays.sort(sortedEdges, uphillPriorityComp);

        for(int idx = 0; idx < n + 1; idx++) {
            parents[idx] = idx;
        }
        int selectedEdgesCnt = 0;

        for(Edge edge : sortedEdges) {
            if(selectedEdgesCnt >= n) break;
            if(find(parents, edge.node[0]) != find(parents, edge.node[1])) {
                if(edge.cost == 0) {
                    max++;
                }
                union(parents, edge.node[0], edge.node[1]);
                selectedEdgesCnt++;
            }
        }

        // 내리막길 우선
        for(int idx = 0; idx < edges.length; idx++) {
            sortedEdges[idx] = edges[idx];
        }
        Arrays.sort(sortedEdges, downhillPriorityComp);
        for(int idx = 0; idx < n + 1; idx++) {
            parents[idx] = idx;
        }

        selectedEdgesCnt = 0;
        for(Edge edge : sortedEdges) {
            if(selectedEdgesCnt >= n) break;
            if(find(parents, edge.node[0]) != find(parents, edge.node[1])) {
                if(edge.cost == 0) {
                    min++;
                }
                union(parents, edge.node[0], edge.node[1]);
                selectedEdgesCnt++;
            }
        }

        answer = max * max - min * min;
        return answer;
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
