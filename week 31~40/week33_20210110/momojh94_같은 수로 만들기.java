/*
 * https://www.acmicpc.net/problem/2374
 * 백준 분할 정복
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        long answer = 0;
        for(int idx = 0; idx < n; idx++) {
            nums[idx] = Integer.parseInt(br.readLine());
        }

        answer = divide(nums, 0, nums[0], nums[0], 0);
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }

    public static long divide(int[] nums, int startPos, int prevMin, int prevMax, long cnt) {
        if(startPos == nums.length) {
            return cnt;
        }

        int curBaseNum = nums[startPos];
        int idx = startPos + 1;
        // 같은 숫자 범위 찾기
        while (idx < nums.length && nums[idx] == curBaseNum) {
            idx++;
        }
        prevMin = curBaseNum < prevMin ? curBaseNum : prevMin;

        if(prevMax <= curBaseNum) {
            return divide(nums, idx, curBaseNum, curBaseNum, cnt + curBaseNum - prevMin);
        } else {
            if(idx == nums.length) {
                return cnt + prevMax - prevMin;
            }
            if(prevMin < curBaseNum) {
                return divide(nums, idx, curBaseNum, prevMax, cnt + curBaseNum - prevMin);
            } else {
                return divide(nums, idx, prevMin, prevMax, cnt);
            }
        }
    }
}