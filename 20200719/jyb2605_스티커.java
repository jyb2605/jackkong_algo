import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T > 0) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[2][N + 1];

            for(int row = 0; row < 2; row++) {
                st = new StringTokenizer(bf.readLine());
                for(int idx = 1; idx <= N; idx++) {
                    map[row][idx] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N + 1];
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for(int idx = 2; idx <= N; idx++) {
                dp[0][idx] = Math.max(dp[1][idx - 1], Math.max(dp[0][idx - 2], dp[1][idx - 2])) + map[0][idx];
                dp[1][idx] = Math.max(dp[0][idx - 1], Math.max(dp[0][idx - 2], dp[1][idx - 2])) + map[1][idx];
            }

            T--;
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }

    }
}

