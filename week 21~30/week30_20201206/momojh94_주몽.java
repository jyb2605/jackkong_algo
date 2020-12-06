/*
 * 2020-12-06
 * 주몽
 * https://www.acmicpc.net/problem/1940
 * 투 포인터
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ret = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] materials = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < n; idx++) {
            materials[idx] = Integer.parseInt(st.nextToken());
        }
        
        if(n >= 2) {
            Arrays.sort(materials);
            int left = 0;
            int right = n - 1;
            int currentSum = materials[0] + materials[right];
            while (left < right) {
                if(currentSum == m) {
                    ret++;
                }
                if(currentSum <= m) {
                    currentSum -= materials[left++];
                    currentSum += materials[left];
                } else {
                    currentSum -= materials[right--];
                    currentSum += materials[right];
                }
            }
        }
        bw.write(Integer.toString(ret));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}