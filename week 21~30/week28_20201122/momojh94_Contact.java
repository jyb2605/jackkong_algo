/*
 * 2020-11-22
 * Contact
 * https://www.acmicpc.net/problem/1013
 * 정규표현식
 * 
 */

import java.io.*;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String reg = "^(100+1+|01)+$";
        String inputStr;

        int t = Integer.parseInt(br.readLine());

        for(int tCnt = 0; tCnt < t; tCnt++) {
            inputStr = br.readLine();
            bw.write(Pattern.matches(reg, inputStr) == true
                    ? "YES"
                    : "NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}