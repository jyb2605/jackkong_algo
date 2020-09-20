/*
 * 2020-06-07
 * https://www.acmicpc.net/problem/7562
 * 백준 7562_나이트의 이동, bfs
 * 
 * 최단거리 쪽은 bfs로 해야 됨.
 */

import java.io.*;
import java.util.*;

class Main {
    static final int[][] MOVE_POS ={{1, -2}, {2, -1}, {2, 1}, {1, 2},
                    {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int l;
        // {x, y}
        int[] currentPos = new int[2];
        int[] targetPos = new int[2];
        boolean[][] map = new boolean[301][301];
        int answer = -1;
        for(int i = 0; i < t; i++)
        {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            currentPos[0] = Integer.parseInt(st.nextToken());
            currentPos[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetPos[0] = Integer.parseInt(st.nextToken());
            targetPos[1] = Integer.parseInt(st.nextToken());
            initializeMap(map, l);
            answer = bfs(map, currentPos, targetPos, l);
            bw.write(Integer.toString(answer));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void initializeMap(boolean[][] map, int size){
        for(int i = 0; i < size; i++){
            Arrays.fill(map[i], 0, size, false);
        }
    }

    public static int bfs(boolean[][] map, int[] initialPos, int[] targetPos, int mapLen) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[] node;
        int x, y;
        q.add(new int[]{initialPos[0], initialPos[1], 0});
        map[initialPos[1]][initialPos[0]] = true;
        if (initialPos[0] != targetPos[0] || initialPos[1] != targetPos[1]) {
            while (!q.isEmpty()) {
                node = q.poll();
                for (int i = 0; i < 8; i++) {
                    x = node[0] + MOVE_POS[i][0];
                    y = node[1] + MOVE_POS[i][1];
                    if (x == targetPos[0] && y == targetPos[1]) {
                        return node[2] + 1;
                    }
                    if (0 <= x && x < mapLen && 0 <= y && y < mapLen && !map[y][x]) {
                        map[y][x] = true;
                        q.add(new int[]{x, y, node[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
}