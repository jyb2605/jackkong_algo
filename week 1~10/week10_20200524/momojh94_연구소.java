/*
 * 2020-05-29
 * https://www.acmicpc.net/problem/14502
 * 
 */

import java.util.*;

public class Main {
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static final int[][] MOVE_POS= {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        int answer = -1;
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int safeArea;
        int[][] originalMap = new int[row][col];
        int[][] map = new int[row][col];
        int[][] emptyPosList = new int[65][2];
        int emptyCnt = 0;
        for(int y = 0; y < row; y++){
            for(int x = 0; x < col; x++){
                originalMap[y][x] = sc.nextInt();
                if(EMPTY == originalMap[y][x]){
                    emptyPosList[emptyCnt][0] = x;
                    emptyPosList[emptyCnt++][1] = y;
                }
            }
        }

        for(int i = 0; i < emptyCnt; i++){
            for(int j = i+1; j < emptyCnt; j++){
                for(int k = j+1; k < emptyCnt; k++){
                    deepCopy(originalMap, map);
                    buildWall(map, emptyPosList, i);
                    buildWall(map, emptyPosList, j);
                    buildWall(map, emptyPosList, k);

                    safeArea = bfs(map);
                    if(answer < safeArea){
                        answer = safeArea;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void deepCopy(int[][] src, int[][] dest){
        for(int i = 0; i < src.length; i++){
            System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
        }
    }

    public static void buildWall(int[][] map, int[][] emptyPosList, int index){
        map[emptyPosList[index][1]][emptyPosList[index][0]] = WALL;
    }

    public static int bfs(int[][] map){
        Queue<int[]> q = new LinkedList<>();
        int[] pos;
        int safeArea = 0;
        int tx, ty;
        int row = map.length;
        int col = map[0].length;
        for(int y = 0; y < row; y++){
            for(int x = 0; x < col; x++){
                if(VIRUS == map[y][x]){
                    q.add(new int[]{x, y});
                }
            }
        }
        while(false == q.isEmpty()){
            pos = q.poll();

            for(int i = 0; i < 4; i++){
                tx = pos[0] + MOVE_POS[i][0];
                ty = pos[1] + MOVE_POS[i][1];

                if(0 <= tx && tx < col && 0 <= ty && ty < row){
                    if(EMPTY == map[ty][tx]){
                        map[ty][tx] = VIRUS;
                        q.add(new int[]{tx, ty});
                    }
                }
            }
        }

        for(int y = 0; y < row; y++){
            for(int x = 0; x < col; x++) {
                if(EMPTY == map[y][x]){
                    safeArea += 1;
                }
            }
        }
        return safeArea;
    }
}