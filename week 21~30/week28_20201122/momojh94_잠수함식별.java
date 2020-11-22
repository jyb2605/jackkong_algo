/*
 * 2020-11-22
 * 잠수함식별
 * https://www.acmicpc.net/problem/2671
 * 정규표현식
 * 
 * contact 문제랑 정규식이 같음
 */

import java.io.*;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String reg = "^(100+1+|01)+$";
        String inputStr;

        inputStr = br.readLine();
        bw.write(Pattern.matches(reg, inputStr) == true
                ? "SUBMARINE"
                : "NOISE");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}