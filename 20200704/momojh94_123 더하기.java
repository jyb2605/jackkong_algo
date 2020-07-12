/*
 * 2020-07-10
 * https://www.acmicpc.net/problem/9095
 * 백준 dp
 *
 */

// 풀이 1 배열에 값 저장하며 해결
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        int t = Integer.parseInt(br.readLine());
        int target;
        for(int i = 0 ; i < t; i++){
            target = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(dp[target]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

// 풀이 2 dfs

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for(int i = 0 ; i < t; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int target : arr){
            bw.write(Integer.toString(dfs(0, target)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static int dfs(int sum, int target){
        int cnt = 0;
        if(sum > target){
            return 0;
        }else if(sum == target){
            return 1;
        }

        cnt += dfs(sum + 1, target)
                + dfs(sum + 2, target)
                + dfs(sum + 3, target);
        return cnt;
    }
}
