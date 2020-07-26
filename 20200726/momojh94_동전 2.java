/*
 * 2020-07-26
 * https://www.acmicpc.net/problem/2294
 * 백준 dp
 *
 * 오늘 두뇌 말랑말랑 해지고 dp에 눈이 조금 텄다.
 *
 * 시간 복잡도 O(nk)
 *
 * 현재 만들어 낸 코인의 합이 dp에 index이다.
 * 현재 index에 해당하는 코인의 합에서 내가 가진 코인들의 각각 값을 뺀 index에서
 * min 값을 찾고 dp에 저장한다.
 * 결국 dp[k]의 값이 0이면 불가능한 경우 이므로 -1 출력 dp[k] 값이 0 보다 크면 dp[k] 출력
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[101];
        int[] dp = new int[10001];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < k+1; i++){
            for(int j = 0; j < n; j++){
                int prevIndex = i - coins[j];
                if(prevIndex < 0){
                    continue;
                }
                if(0 < prevIndex & 0 == dp[prevIndex]){
                    continue;
                }
                if(0 == dp[i]){
                    dp[i] = dp[prevIndex] + 1;
                }else if(dp[prevIndex] + 1 < dp[i]){
                    dp[i] = dp[prevIndex] + 1;
                }
            }
        }

        answer = 0 < dp[k] ? dp[k] : -1;
        bw.write(Integer.toString(answer));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}