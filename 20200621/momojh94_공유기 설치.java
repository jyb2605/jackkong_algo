/*
 * 2020-06-21
 * https://www.acmicpc.net/problem/2110
 * 백준 이분 탐색
 *
 * 프로그래머스 징검다리랑 비슷한 문제
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
        int c = Integer.parseInt(st.nextToken());
        int[] homes = new int[n];

        for(int i = 0; i < n; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        bw.write(Integer.toString(binarySearch(homes, c)));
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int[] homes, int c){
        int distance = homes[homes.length - 1] - homes[0];
        int start = 1;
        int end = distance;
        int mid = 0;
        int wifiCnt = 0;
        int prePos = 0;

        while (start <= end){
            mid = (start + end) / 2;
            wifiCnt = 1;
            prePos = homes[0];
            for(int i = 1; i < homes.length; i++){
                if(homes[i] - prePos >= mid){
                    prePos = homes[i];
                    wifiCnt++;
                }
            }
            if(wifiCnt < c){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}