/*
 * 2020-05-22
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 프로그래머스 코딩테스트 고득점 Kit
 *
 * 1. 각 단어를 노드로 두고 변환할 수 있는 경우 간선으로 연결(한 번에 한 개의 알파벳만 바꾸기, words에 있는 단어로만 변환)
 * 2. words내의 target 단어가 없으면 0 반환
 * 3. begin을 시작으로 bfs를 통해 탐색하여 target 찾고 횟수 반환
 *
 * 문자열 비교할 때 ==로 비교하면 로컬환경은 적용되나 온라인(프로그래머스)에서 안됨. equals로 비교하게 수정
 */

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        List<List<Integer>> edges = new ArrayList<>(n+3);
        boolean[] visit = new boolean[n+3];
        boolean t = false;
        
        for(int i = 0 ; i < n; i++){
            visit[i] = false;   
            if(words[i].equals(target)){
                t = true;
            }
            edges.add(new ArrayList<>());
            for(int j = 0 ; j < n; j++){
                if(canChangeWord(words[i], words[j])){
                    edges.get(i).add(j);
                }
            }
        }
        if(!t){
            return 0;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(canChangeWord(begin, words[i])){
                q.add(i);
            }
        }
        answer = bfs(visit, edges, words, target, 1, q);

        return answer;
    }
    
    public boolean canChangeWord(String begin, String target){
        int diff = 0;
        if(begin == target){
            return false;
        }
        for(int i = 0 ; i < begin.length(); i++){
            if(begin.charAt(i) != target.charAt(i)){
                diff += 1;
                if(diff >= 2){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int bfs(boolean[] v, List<List<Integer>> edges, String[] words, String target, int r, Queue<Integer> q){
        int vertex = 0;
        int next = 0;
        Queue<Integer> q2 = new LinkedList<Integer>();
        while(false == q.isEmpty()){
            vertex = q.poll();
            if(words[vertex].equals(target)){
                return r;
            }
            for(int i = 0; i < edges.get(vertex).size(); i++){
                next = edges.get(vertex).get(i);
                //if(words[next].equals(target)){
                //    return r+1;
                //}
                if(false == v[next]){
                    v[next] = true;
                    q2.add(next);
                }
            }
        }
        return bfs(v, edges, words, target, r+1, q2);
    }
}