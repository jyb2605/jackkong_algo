import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int row = 1; row <= str1.length(); row++) {
            for(int col = 1; col <= str2.length(); col++) {
                if(str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                }else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
