/*
 * 2020-12-06
 * 용액
 * https://www.acmicpc.net/problem/2467
 * 투 포인터
 * 
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
        int minDiff = 1555555555;
        int n = Integer.parseInt(br.readLine());
        int[] waters = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < n; idx++) {
            waters[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int currentSum = waters[0] + waters[right];
        int currentDiff = 0;
        while (left < right) {
            currentDiff = currentSum >= 0
                    ? currentSum
                    : -currentSum;
            if(currentDiff < minDiff) {
                minDiff = currentDiff;
                retLeftNum = waters[left];
                retRightNum = waters[right];
                if(currentDiff == 0) {
                    break;
                }
            }

            if(currentSum < 0) {
                currentSum -= waters[left++];
                currentSum += waters[left];
            }else {
                currentSum -= waters[right--];
                currentSum += waters[right];
            }
        }

        bw.write(retLeftNum + " " + retRightNum);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}