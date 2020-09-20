/*
 * 2020-07-19
 * https://www.acmicpc.net/problem/9465
 * 백준 dp
 * 
 * 너무 어렵다. 답 설명 듣고 품
 *
 * 스티커 인덱스 i에 위에꺼를 고르면 이전에 i-1번 째와 i-2번 째 아래 스티커를
고를 수 있으니 dp[1][i-1]와 dp[1][i-2] 에서 큰 값을 골라서 스티커[0][i]를 더 해주면 되고
똑같이 스티커 i번 째에 아래 것을 고르면 dp[0][i-1]와 dp[0][i-2]에서 큰 값을 골라 더 하면 된다.
dp 마지막 인덱스에서 위에 값이나 아래 값중 큰 값을 출력하면 답
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int[][] dp = new int[2][100007];
        int[][] sticker = new int[2][100007];
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        for(int i = 0 ; i < t; i++){
            n = Integer.parseInt(br.readLine());
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 2; k < n+2; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int l = 2; l < n+2; l++){
                dp[0][l] = dp[1][l-2] > dp[1][l-1] ? dp[1][l-2] + sticker[0][l] : dp[1][l-1] + sticker[0][l];
                dp[1][l] = dp[0][l-2] > dp[0][l-1] ? dp[0][l-2] + sticker[1][l] : dp[0][l-1] + sticker[1][l];
            }
            bw.write(Integer.toString(Math.max(dp[0][n+1], dp[1][n+1])));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}