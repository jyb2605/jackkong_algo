/*
 * 2020-07-10
 * https://www.acmicpc.net/problem/1463
 * 백준 dp
 * 
 * 예전에 C++로 풀었던 1번 방법이 더 좋아보여서 했더니 2번보다 빠르고 메모리 적게 쓴다.
 * 시간 : 1번 104ms < 2번 132ms
 * 메모리 : 1번 17654 KB < 2번 40748 KB
 *
 * 1번 풀이 ---
 * index 2부터 n까지 dp의 index X-1, X/2, X/3 값 중 제일 작은 연산 값을 찾고 그 값에 +1한 값을 dp[i]에 저장한다.
 * index X/2는 X가 2로 나누어 떨어질 때, X/3는 X가 3으로 나누어 떨어질 때 참조한다.
 * n까지의 반복문이 끝나면 dp[n] 출력하면 정답
 *
 * 2번 풀이 주의---
 * dfs 함수내에 
 * if(0 != dp[current] && dp[current] < cnt){
            return;
   }
처음에 dp[current] < cnt 이 조건만 넣었더니
dp 배열이 만들어질 때 0값으로 초기화 되어서
해당 index의 숫자가 첫 방문될 때 cnt 대입이 안됨.
current 숫자가 처음으로 방문된 경우 cnt 대입을 해줘야 되므로
0 != dp[current] 조건 추가 했음.
 *
 */

// 1번 풀이 - 1부터 n까지 주어진 연산을 하며 dp로 풀기

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1] = 0;
        for(int i = 2; i < n+1; i++){
            dp[i] += dp[i-1] + 1;
            if(0 == i % 2 && dp[i/2] + 1 < dp[i]){
                dp[i] = dp[i/2] + 1;
            }
            if(0 == i % 3 && dp[i/3] + 1 < dp[i]){
                dp[i] = dp[i/3] + 1;
            }
        }
        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }
}

// 2번 풀이 - n부터 1까지 dfs로 더 적은 연산 횟수 찾기

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