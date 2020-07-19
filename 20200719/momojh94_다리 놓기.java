/*
 * 2020-07-19
 * https://www.acmicpc.net/problem/1010
 * 백준 dp
 * 
 * 어렵다....
 * nCr = n-1Cr-1 + n-1Cr 식을 이용해서 dp에 값 저장하고
 * T만큼 받은 n과 m을 mCn으로 dp[m][n] 출력하면 답이다.
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int[][] dp = new int[31][31];
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        int m = 0;
        for(int i = 0; i < 30; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < 30; i++){
            for(int j = 1; j < i+1; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(dp[m][n]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}