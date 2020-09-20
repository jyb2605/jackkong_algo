/*
 * 2020-07-16
 * https://www.acmicpc.net/problem/2156
 * 백준 dp - 포도주 시식
 *
 * 점화식 세워서 dp로 풀고 싶었으나 풀이 접근 조차 못함.
 * 시간 초과 걸릴 것 같았지만 dfs로 풀어봄. => 시간 초과
 * 며칠 더 생각 해봤는데 못 풀어서 블로그 해설글 보고 품.
 * 
 * 다음에 비슷한 문제 단어만 바꿔서 나오면 또 점화식 못 세우고
 * 못 풀 것 같다.
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;
        int[] dp = new int[10013];
        int[] wines = new int[10013];
        n = Integer.parseInt(br.readLine());
        for(int i = 3; i < n+3; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 3; i < n+3; i++){
            dp[i] = Math.max(dp[i-2] + wines[i], dp[i-3] + wines[i-1] + wines[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        bw.write(Integer.toString(dp[n+2]));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}