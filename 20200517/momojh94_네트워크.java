/*
 * 2020-05-22
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * 프로그래머스 코딩테스트 고득점 Kit
 * 예전에 c++로 이미 풀었던 문제 java로 다시 작성
 * 1. 1부터 n번 컴퓨터까지 i번을 시작으로 bfs 탐색
 * 2. 이미 방문했던 노드는 탐색하지 않고 처음으로 탐색할 때(bfs 함수 처음 진입할 때) answer값에 +1, 모든 탐색이 완료되면 answer 반환
 */

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(false == visit[i]){
                answer += 1;
                bfs(computers, visit, i);
            }
        }
        return answer;
    }
    
    public void bfs(int[][] edges, boolean[] visit, int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        int vertex = 0;
        while(false == q.isEmpty()){
            vertex = q.poll();
            visit[vertex] = true;
            for(int i = 0; i < edges.length; i++){
                if(false == visit[i] && 1 == edges[vertex][i] && vertex != i){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}