iimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int virusNum = 0, result = 1000000000;
    private static int [][] sandBox;
    private static ArrayList<Point> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N, M, wall = 0;
        String input;
        input = bf.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int[][] map = new int[N + 2][M + 2];
        sandBox = new int[N+2][M+2];

        for(int i = 0; i <= N + 1; i++) {
            map[i][0] = 1;
            map[i][M+1] = 1;
        }

        for(int i = 0; i <= M + 1; i++) {
            map[0][i] = 1;
            map[N+1][i] = 1;
        }

        for(int idx = 1; idx <= N; idx++){
            input = bf.readLine();
            st = new StringTokenizer(input);
            for(int idx2 = 1; idx2 <= M; idx2++){
                map[idx][idx2] = Integer.parseInt(st.nextToken());
                if(map[idx][idx2] == 1)
                    wall++;
                else if(map[idx][idx2] == 2){
                    virus.add(new Point(idx, idx2));
                    virusNum++;
                }
            }
        }

        for(int idx = 1; idx <= N; idx++){
            for(int idx2 = 1; idx2 <= M; idx2++) {
                if(map[idx][idx2] == 0){
                    map[idx][idx2] = 1;
                    dfs(1, N, M, map, idx, idx2);
                    map[idx][idx2] = 0;
                }
            }
        }

        System.out.println(N*M - wall - 3 - result);
    }

    private static void dfs(int walls, int N, int M, int[][] map, int x, int y){
        if(walls == 3){
            for(int i = 0; i < N + 2; i++){
                sandBox[i] = map[i].clone();
            }

            virusNum = 0;
            for (Point p : virus) {
                spreadVirus(p.x, p.y);
            }

            result = Math.min(result, virusNum);
            return;
        }

        for(int i = x; i <= N; i ++){
            for(int j = 1; j <= M; j++){
                if(i == x && j <= y){
                    j = y;
                    continue;
                }
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(walls + 1, N, M, map, i, j);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void spreadVirus(int x, int y){
        sandBox[x][y] = 2;
        virusNum++;

        if( sandBox[x-1][y] == 0)
            spreadVirus(x-1, y);
        if( sandBox[x+1][y] == 0)
            spreadVirus(x+1, y);
        if( sandBox[x][y-1] == 0)
            spreadVirus(x, y-1);
        if( sandBox[x][y+1] == 0)
            spreadVirus(x, y+1);
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

