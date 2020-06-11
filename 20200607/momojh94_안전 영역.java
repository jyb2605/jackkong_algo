/*
 * 2020-06-07
 * https://www.acmicpc.net/problem/2468
 * 백준 2468_안전 영역
 * bfs, dfs
 * 
 * 
 * 비가 내려 잠기는 높이 1부터 ~ 주어진 높이 max 까지 순회하여 안전 영역 최대치 구하고 출력.
 * -> 처음 제출 때 틀렸는데 아무 지역도 물에 잠기지 않을 경우 고려 못함.
 * 
 * n x n visit 배열을 순회하여 잠기는 높이 i 이하인 위치는 모두 visit[y][x] = true한다
 * 그 후 다시 n x n visit 배열을 순회하여 안 잠겼던 위치를 기준으로 bfs를 하고 첫 bfs함수 진입 때 safeArea 갯수를 더 한다. 구한 안전 영역의 갯수 중 최대 개수를 출력한다.
 */

import java.io.*;
import java.util.*;

class Main {
    static final int[][] MOVE_POS ={{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];
        boolean[][] visit = new boolean[101][101];
        int max = -1;
        int answer = 1;
        int num;
        int safeArea;
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(max < num){
                    max = num;
                }
            }
        }

        for(int i = 1; i <= max; i++){
            safeArea = 0;
            for(int y = 0; y < n; y++){
                for(int x = 0; x < n; x++){
                    visit[y][x] = (map[y][x] <= i);
                }
            }
            for(int y = 0; y < n; y++){
                for(int x = 0; x < n; x++){
                    if(!visit[y][x]){
                        safeArea += 1;
                        bfs(visit, n, x, y);
                    }
                }
            }
            if(answer < safeArea){
                answer = safeArea;
            }
        }
        bw.write(Integer.toString(answer));
        bw.newLine();
        bw.flush();
        bw.close();
    }

    public static void bfs(boolean[][] visit, int n, int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[] pos;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            pos = q.poll();
            for (int i = 0; i < 4; i++) {
                x = pos[0] + MOVE_POS[i][0];
                y = pos[1] + MOVE_POS[i][1];
                if (0 <= x && x < n && 0 <= y && y < n && !visit[y][x]) {
                    visit[y][x] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}