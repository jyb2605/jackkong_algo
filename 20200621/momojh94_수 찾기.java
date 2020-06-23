/*
 * 2020-06-21
 * https://www.acmicpc.net/problem/1920
 * 백준 - 이분 탐색
 *
 * 해쉬로 풀어도 됨.
 */

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        for(int num : a){
            bw.write(Integer.toString(binarySearch(nums, num) ? 1 : 0));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static boolean binarySearch(int[] nums, int num){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        int temp = 0;
        while (start <= end){
            mid = (start + end) / 2;
            temp = nums[mid];
            if(num < temp){
                end = mid - 1;
            }else if(num > temp){
                start = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}