/*
 * 2020-07-20
 * https://www.acmicpc.net/problem/9251
 * 백준 dp
 *
 * 진짜 어렵다. 자력으로 못 품.
 * 정답 설명 듣고 풀었음.
 * 2차원 배열로 만들고 주어진 두 개의 string 각 문자가 같을 때와 다를 때
 * 나누어서 같을 때는 왼쪽 대각선 값 + 1 저장 문자가 다를 때는 현재 위치에서
 * dp (x-1, y)위치 와 (x, y-1)의 값 중 max값 저장하여 처리
 * 
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String f = br.readLine();
        String s = br.readLine();

        int[][] dp = new int[s.length()+1][f.length()+1];

        for(int y = 1; y < s.length()+1; y++){
            for(int x = 1; x < f.length()+1; x++){
                if(f.charAt(x-1) == s.charAt(y-1)){
                    dp[y][x] = dp[y-1][x-1] + 1;
                }else{
                    dp[y][x] = Math.max(dp[y-1][x], dp[y][x-1]);
                }
            }
        }

        bw.write(Integer.toString(dp[s.length()][f.length()]));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}