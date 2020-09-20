/*
 * 2020-07-10
 * https://www.acmicpc.net/problem/11726
 * 백준 dp
 * 
 * long타입으로 dp 배열 선언하고 n개 까지의 dp값 구하고
출력할 때 % 10007 해줬는데 long조차도 범위가 넘는지 틀렸다.
 * 
 * int타입 dp 배열 선언하고 index 3부터 n번 까지 이전에 계산된 값으로
dp값 구할 때 마다 % 10007 해줬더니 정답
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        int n = Integer.parseInt(br.readLine());
        for(int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 10007;
        }
        bw.write(Integer.toString(dp[n]));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}