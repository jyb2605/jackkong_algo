import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final static int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for(int col = 1; col < N + 1; col++) {
            for(int row = 1; row < N + 1; row++) {
                map[col][row] = INF;
            }
        }

        for(int num = 0; num < M; num++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[b][a] = 1;
        }

        for(int mid = 1; mid < N + 1; mid++) {
            for(int row = 1; row < N + 1; row++) {
                for(int col = 1; col < N + 1; col++) {
                    if(row != col) {
                        map[row][col] = Math.min(map[row][col], map[row][mid] + map[mid][col]);
                    }
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());

        for(int idx = 0; idx < K; idx++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(map[a][b] < INF) {
                System.out.println(1);
            }
            else if(map[b][a] < INF) {
                System.out.println(-1);
            }else{
                System.out.println(0);
            }
        }

    }
}

