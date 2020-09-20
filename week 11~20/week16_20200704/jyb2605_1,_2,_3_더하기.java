import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(bf.readLine());
            int value = Integer.parseInt(st.nextToken());

            System.out.println(function(value));
        }
    }

    static int function(int value) {
        if(dp[value] != 0){
            return dp[value];
        }

        if(value - 1 >= 0) {
            dp[value] += function(value - 1);
        }
        if(value - 2 >= 0) {
            dp[value] += function(value - 2);
        }
        if(value - 3 >= 0) {
            dp[value] += function(value - 3);
        }

        return dp[value];
    }
}
