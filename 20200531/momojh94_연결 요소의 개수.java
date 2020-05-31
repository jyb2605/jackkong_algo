/*
 * 2020-05-31
 * https://www.acmicpc.net/problem/11724
 *
 * 인접 행렬은 n이 작을 때 쓰거나 플로이드 워셜 알고리즘 때 사용
 * n이 크면 메모리 초과 뜰 수도(실제로 메모리 초과 뜸)
 * boolean[][] -> List<List<Integer>>로 수정
 * 
 * dfs, bfs 둘 다됨.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visit = new boolean[n+1];
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n; i++){
            edges.add(new ArrayList<Integer>());
        }
        int u, v;
        for(int i = 0 ; i < m; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                dfs(visit, edges, i, n);
                answer += 1;
            }
        }
        System.out.println(answer);
    }


    public static void dfs(boolean[] visit, List<List<Integer>> edges, int startNode, int n){
        Stack<Integer> s = new Stack<Integer>();
        int node = 1;
        visit[startNode] = true;
        for(int i = 0; i < edges.get(startNode).size(); i++){
            node = edges.get(startNode).get(i);
            if(!visit[node]){
                visit[node] = true;
                s.add(node);
            }
        }
        while(false == s.isEmpty()){
            startNode = s.pop();
            for(int i = 0; i < edges.get(startNode).size(); i++){
                node = edges.get(startNode).get(i);
                if(!visit[node]){
                    visit[node] = true;
                    s.add(node);
                }
            }
        }
    }
}