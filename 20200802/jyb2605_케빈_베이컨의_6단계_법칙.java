import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for(int col = 1; col < N + 1; col++) {
            for(int row = 1; row < N + 1; row++) {
                map[col][row] = 10000;
            }
        }

        for(int num = 0; num < M; num++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int mid = 1; mid < N + 1; mid++) {
            for(int row = 1; row < N + 1; row++) {
                for(int col = 1; col < N + 1; col++) {
                    if(row != col) {
                        map[row][col] = Math.min(map[row][col], map[row][mid] + map[mid][col]);
                        map[col][row] = map[row][col];
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int who = 0;
        for(int row = 1; row < N + 1; row++) {
            int sum = 0;
            for(int idx = 1; idx < N + 1; idx++) {
                sum += map[row][idx];
            }
            if(result > sum) {
                result = sum;
                who = row;
            }
        }

        System.out.println(who);
    }
}

