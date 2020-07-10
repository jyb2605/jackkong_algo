/*
 * 2020-07-10
 * https://www.acmicpc.net/problem/1463
 * 백준 dp
 *
 * dfs 함수내에 
 * if(0 != dp[current] && dp[current] < cnt){
            return;
   }
처음에 dp[current] < cnt 이 조건만 넣었더니
dp 배열이 만들어질 때 0값으로 초기화 되어서
해당 index의 숫자가 첫 방문될 때 cnt 대입이 안됨.
current 숫자가 처음으로 방문된 경우 cnt 대입을 해줘야 되므로
0 != dp[current] 조건 추가 했음.
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dfs(dp, n, 0);
        bw.write(Integer.toString(dp[1]));
        bw.flush();
        bw.close();
    }

    public static void dfs(int[] dp, int current, int cnt){
        if(0 != dp[current] && dp[current] < cnt){
            return;
        }else{
            dp[current] = cnt;
        }
        if(1 == current){
            return;
        }
        if(0 == (current % 3)){
            dfs(dp, current / 3, cnt + 1);
        }
        if(0 == (current % 2)){
            dfs(dp, current / 2, cnt + 1);
        }
        dfs(dp, current - 1, cnt + 1);
    }
}