/*
 * 2020-11-29
 * 부분합
 * https://www.acmicpc.net/problem/1806
 * 투 포인터
 * 
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int LEN_MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        int ret = 0;
        for(int idx = 0; idx < n; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }

        int lenMax = LEN_MAX;
        int left = 0;
        int right = 0;
        int currentLen = 1;
        int currentSum = nums[0];

        while (left < n && right < n) {
            if(currentSum >= s && currentLen < lenMax) {
                lenMax = currentLen;
            }

            if(currentSum >= s) {
                currentSum -= nums[left++];
                currentLen--;
                if(left > right) {
                    right = left;
                    currentSum = nums[right];
                    currentLen = 1;
                }
            } else {
                currentSum += nums[++right];
                currentLen++;
            }
        }

        if(lenMax != LEN_MAX) {
            ret = lenMax;
        }
        bw.write(Integer.toString(ret));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
