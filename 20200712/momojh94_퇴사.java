/*
 * 2020-07-13
 * https://www.acmicpc.net/problem/14501
 * 백준 dp
 *
 * 예전에 c++로 푼거는 dfs로 완탐해서 풀고 이번껀 dp로 해결
 *
 * # 풀이
 * 1일 부터 n일까지 반복하여
 * 매 i번째 요일마다 상담을 할 수 있는 경우 상담 했을 때 이익을
 * i+ti 날에 이익과 비교하여 i+ti날 dp값에 더 큰 값 저장.
 * 현재 요일 과 하루 전 요일 중 더 큰 이익을 현재 요일 dp값에저장.
 *
 * # 틀렸을 때
 * 중간에 dp[i] 값이 0인 날은 바로 이전 날 dp[i-1] 값을 대입 하게 했는데
 * 1->3->6 으로 와서 dp[6] = 45인 거랑
 * 1->2->5 으로 와서 dp[5] = 55일 때
 * if(dp[i-1] > dp[i])
   {
       dp[i] = dp[i-1];
   }
 * 전 날 이익이 더 크면 전 날 이익값을 저장하게 끔 해서
 * dp[6]에 값이 45 -> 55가 되게 했어야 되었는데
 * 위와 같은 상황을 고려하지 않고 해당 요일에 접근을 한 번도 하지 않았을 때만(0 == dp[i])
 * 전 날 이익값을 가져와 저장해서 틀렸었다.
 */

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] dp = new int[22];
        int[][] works = new int[22][2]; //{ti, pi}
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n+1; i++){
            if(dp[i-1] > dp[i]){
                dp[i] = dp[i-1];
            }
            if(i + works[i][0] <= n+1){
                if(dp[i] + works[i][1] > dp[i + works[i][0]]){
                    dp[i + works[i][0]] = dp[i] + works[i][1];
                }
            }else{
                if(dp[i] > dp[n+1]){
                    dp[n+1] = dp[i];
                }
            }
        }

        bw.write(Integer.toString(dp[n+1]));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}