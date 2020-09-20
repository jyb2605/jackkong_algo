import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp = new long[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        dp[1] = 1;
        dp[2] = 2;

        int value = Integer.parseInt(st.nextToken());

        System.out.println(function(value));
    }

    static long function(int value) {
        if (dp[value] != 0) {
            return dp[value];
        }

        dp[value] = function(value - 1) + function(value - 2);
        dp[value] %= 10007;

        return dp[value];
    }
}
