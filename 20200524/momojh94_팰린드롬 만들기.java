/*
 * 2020-05-25
 * https://www.acmicpc.net/problem/121
 *
 * 예전에 c++ 푼 문제 Java로 다시 풂.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String impossible = "I'm Sorry Hansoo";
        int oddCnt = 0;
        char oddChar = 'A';
        int asciiA = 'A';
        int[] wordsCnt = new int[26];
        int wordAscii;
        char printChar;

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int strLen = str.length();

        for(int i = 0; i < strLen; i++){
            wordAscii = (int)str.charAt(i) - asciiA;
            wordsCnt[wordAscii] += 1;
        }
        List<Character> resultWordsHalf = new ArrayList<>(str.length() / 2);
        for(int i =0 ; i < 26; i++){
            if(1 == wordsCnt[i] % 2){
                oddCnt += 1;
                oddChar = (char)(asciiA + i);
                if(2 <= oddCnt){
                    System.out.println(impossible);
                    break;
                }
            }
            if(2 <= wordsCnt[i]){
                printChar = (char)(asciiA + i);
                for (int j = 0; j < wordsCnt[i] / 2; j++)
                {
                    resultWordsHalf.add(printChar);
                }
            }
        }

        if(2 > oddCnt){
            for(int i = 0; i < resultWordsHalf.size(); i++){
                System.out.print(resultWordsHalf.get(i));
            }
            if(1 == oddCnt){
                System.out.print(oddChar);
            }
            for(int i = resultWordsHalf.size() - 1; i >= 0 ; i--){
                System.out.print(resultWordsHalf.get(i));
            }
        }
    }
}