/*
 * 2020-06-21
 * https://www.acmicpc.net/problem/2805
 * 백준 - 이분 탐색
 */

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Long.toString(binarySearch(trees, m)));
        bw.flush();
        bw.close();
    }

    public static Long binarySearch(int[] trees, int m){
        long start = 0;
        long end = -1;
        long mid = 0;
        long sum = 0;

        for(int num : trees){
            if(end < num){
                end = num;
            }
        }

        while (start <= end){
            mid = (start + end) / 2;
            sum = 0;
            for(int num : trees){
                sum += num >= mid ? num - mid : 0;
                if(sum > m){
                    break;
                }
            }
            if(sum >= m){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}