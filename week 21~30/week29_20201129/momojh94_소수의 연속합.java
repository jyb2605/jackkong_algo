/*
 * 2020-11-29
 * 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 * 투 포인터
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        if(n >= 2) {
            boolean[] visited = new boolean[n + 1];
            ArrayList<Integer> prime = new ArrayList<>();
            for(int num = 2; num <= n; num++) {
                if(!visited[num]) {
                    prime.add(num);
                    for(int idx = num + num; idx <= n; idx += num) {
                        visited[idx] = true;
                    }
                }
            }

            int left = 0;
            int right = 0;
            int currentSum = prime.get(0);
            int len = prime.size();
            while (left < len) {
                if(currentSum == n) {
                    ret++;
                }

                if(currentSum > n) {
                    currentSum -= prime.get(left++);
                    if(left > right) {
                        if(++right >= len) {
                            break;
                        }
                        currentSum = prime.get(right);
                    }
                } else {
                    if(++right >= len) {
                        break;
                    }
                    currentSum += prime.get(right);
                }
            }
        }

        bw.write(Integer.toString(ret));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
