/*
 * 2021-02-12
 * https://www.acmicpc.net/problem/1212
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = null;
        int num;
        sb = new StringBuilder();
        num = str.charAt(0) - '0';
        for(int base = 0; base < 3; base++) {
            sb.append(num % 2);
            num /= 2;
        }
        answer.append(Integer.parseInt(sb.reverse().toString()));

        for(int idx = 1; idx < str.length(); idx++) {
            sb = new StringBuilder();
            num = str.charAt(idx) - '0';
            for(int base = 0; base < 3; base++) {
                sb.append(num % 2);
                num /= 2;
            }
            answer.append(sb.reverse());
        }
        System.out.println(answer);
    }
}