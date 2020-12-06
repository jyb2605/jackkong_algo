/*
 * 2020-12-06
 * 용액
 * https://www.acmicpc.net/problem/2467
 * 투 포인터
 * 
 * minDiff 초기 값 때문에 틀림.
 * 10억+ (10억-1) 로 하면 20억 - 1 까지 나올 수 있는데 초기 값 15억으로 해서
 * 75%에서 틀렸음.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int retLeftNum = 0;
        int retRightNum = 0;
        int n = Integer.parseInt(br.readLine());
        int[] waters = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < n; idx++) {
            waters[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int currentDiff = 0;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            currentDiff = Math.abs(waters[left] + waters[right]);
            if(currentDiff < minDiff) {
                minDiff = currentDiff;
                retLeftNum = waters[left];
                retRightNum = waters[right];
                if(currentDiff == 0) {
                    break;
                }
            }

            if(waters[left] + waters[right] < 0) {
                left++;
            }else {
                right--;
            }
        }

        String str = retLeftNum + " " + retRightNum;
        bw.write(str);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}