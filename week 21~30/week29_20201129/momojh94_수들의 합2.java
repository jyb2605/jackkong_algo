/*
 * 2020-11-29
 * 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 * 투 포인터
 * 
 */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        int ret = 0;
        for(int idx = 0; idx < n; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int currentSum = nums[0];

        while (left < n && right < n) {
            if(currentSum == m) {
                ret++;
            }

            if(currentSum > m) {
                currentSum -= nums[left++];
                if(left > right) {
                    right = left;
                    currentSum += nums[right];
                }
            } else {
                currentSum += nums[++right];
            }
        }

        bw.write(Integer.toString(ret));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
