import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_VALUE = 31;
    private static int[][] dp = new int[MAX_VALUE][MAX_VALUE];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T > 0) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(calc(N, M));

            T--;
        }

    }

    private static int calc(int n, int m) {
        if(n == m | n == 0){
            return 1;
        }
        else if(dp[n][m] > 0) {
            return dp[n][m];
        }
        else {
            return (dp[n][m] = calc(n- 1, m - 1) + calc(n, m - 1));
        }
    }
}

