/*
 * 2020-05-31
 * https://www.acmicpc.net/problem/1697
 * 백준 1697_숨바꼭질
 * 
 * 조심 : if (0 <= nextPos[i] && nextPos[i] <= 100000 && !visit[nextPos[i]]) {
 * 여기에서 조건문 순서에 따라서 index out of range error 발생할 수도 있음
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] visit = new boolean[100001];
        int me = sc.nextInt();
        int target = sc.nextInt();
        System.out.println(bfs(me, target, visit));
    }

    public static int bfs(int beginPos, int target, boolean[] visit) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[] nextPos = new int[3];
        int[] node;
        int cnt = 0;
        q.add(new int[]{beginPos, 0});
        while (!q.isEmpty()) {
            node = q.poll();
            cnt = node[1];
            if (target == node[0]) {
                break;
            }
            nextPos[0] = node[0] - 1;
            nextPos[1] = node[0] + 1;
            nextPos[2] = node[0] * 2;

            for (int i = 0; i < 3; i++) {
                if (0 <= nextPos[i] && nextPos[i] <= 100000 && !visit[nextPos[i]]) {
                    q.add(new int[]{nextPos[i], cnt + 1});
                    visit[nextPos[i]] = true;
                }
            }
        }
        return cnt;
    }
}