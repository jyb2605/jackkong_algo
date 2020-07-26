/*
 * 2020-07-27
 * https://www.acmicpc.net/problem/2011
 * 백준 dp
 *
 * 첫 제출 때 15%쯤에서 틀림.
 * 고쳐서 제출해 보다가 안돼서 질문 검색란에서
 * https://www.acmicpc.net/board/view/52607 반례 보고 풂.
 *
 * 걸렸던 반례 1
 * 입력 : 30, 답 : 0, 실제 출력 : 1
 * 30, 40, 50, ..., 90 같은 암호를 해석할 수 없는 경우 예외 처리 추가
 *
 * 반례 2
 * 입력 : 2220, 답 : 2, 실제 출력 : 3
 * 풀면서 10, 20에 대한 처리를 생각했지만 실제 코드 짜다 보니 빼먹고 짬.
 * 10, 20에 경우 dp[i-2] 값을 가지도록 수정
 */

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int answer = solution(input);
        bw.write(Integer.toString(answer));
        bw.newLine();
        bw.flush();
        bw.close();
    }
    public static int solution(String code){
        int[] dp = new int[5005];
        dp[0] = 1;
        dp[1] = 1;
        int n = code.length();
        int prev;
        int current;
        if(0 == ((int)code.charAt(0) - 48)){
            return 0;
        }

        for(int i = 2; i < n + 1; i++){
            prev = (int)code.charAt(i-2) - 48;
            current = (int)code.charAt(i-1) - 48;
            dp[i] = dp[i-1];

            if(0 == prev){
                if(0 == current){
                    return 0;
                }
            } else if(1 == prev){
                if(0 == current){
                    dp[i] = dp[i-2];
                } else if(current <= 9){
                    dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
                }
            } else if(2 == prev){
                if(0 == current){
                    dp[i] = dp[i-2];
                } else if(current <= 6){
                    dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
                }
            } else {
                if(0 == current){
                    return 0;
                }
            }
        }
        return dp[n];
    }
}