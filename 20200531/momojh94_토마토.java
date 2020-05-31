/*
 * 2020-05-31
 * https://www.acmicpc.net/problem/7576
 * 백준 7576_토마토
 * 조심 - bfs에서 다음 bfs 호출 할 때 새로운 큐 안 비어있는지 체크
 * 조건문 안하면 bfs내에서 무한 루프
 * if(!q2.isEmpty()) {
 *     day += 1;
 *     bfs(map, q2, n, m);
 * }
 * 
 * 함수 매개변수로 int말고도 Integer도 값만 넘겨서 answer인 day static 변수로 빼줘서 품.
 */

import java.util.*;

public class Main {
    private static final int[][] DIR = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static int day = 0;
    private static int unripeTomatoCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<int[]> q = new LinkedList<int[]>();

        int[][] map = new int[m][n];
        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++) {
                map[y][x] = sc.nextInt();
                if(0 == map[y][x]){
                    unripeTomatoCnt += 1;
                }
                else if(1 == map[y][x]){
                    q.add(new int[]{x, y});
                }
            }
        }

        bfs(map, q, n, m);
        if(0 == unripeTomatoCnt){
            System.out.println(day);
        }
        else{
            System.out.println(-1);
        }
    }

    public static void bfs(int[][] map, Queue<int[]> q, int n, int m){
        Queue<int[]> q2 = new LinkedList<int[]>();
        int[] pos = new int[]{0, 0};
        int tx, ty;
        while(!q.isEmpty()){
            pos = q.poll();
            for(int i = 0; i < 4; i++){
                tx = pos[0] + DIR[i][0];
                ty = pos[1] + DIR[i][1];
                if(0 <= tx && tx < n && 0 <= ty && ty < m){
                    if(0 == map[ty][tx]){
                        unripeTomatoCnt -= 1;
                        map[ty][tx] = 1;
                        q2.add(new int[]{tx, ty});
                    }
                }
            }
        }

        if(!q2.isEmpty()) {
            day += 1;
            bfs(map, q2, n, m);
        }
    }
}