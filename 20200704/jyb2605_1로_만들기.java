import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = 1000000;
    static Integer[] dp = new Integer[MAX_VALUE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        dp[1] = 0;

        int value = Integer.parseInt(st.nextToken());

        System.out.println(function(value));
    }

    static int function(int value) {
        if (dp[value] != null) {
            return dp[value];
        }

        dp[value] = Math.min(function(value - 1) + 1,
            Math.min(value % 2 == 0 ? function(value / 2) + 1 : MAX_VALUE,
                value % 3 == 0 ? function(value / 3) + 1 : MAX_VALUE));

        return dp[value];
    }
}

