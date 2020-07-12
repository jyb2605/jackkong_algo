/*
 * 2020-07-12
 * https://www.acmicpc.net/problem/1932
 * 백준 dp
 * 
 * 메모리 32204KB, 시간 336ms
 *
 * List<List<Integer>> numbers
 *
 * numbers 를 순회하는 index y와 number.get(y)에 있는 list를 순회하는 index x가 있으면
 * a
 * b c
 * d e f
 * h i j k
 *
 * 양 사이드에 있는 d, f 경우 d에서 h방향으로 f에서 k방향으로 내려가서 값을 더하면 되는데
 * 그 사이에 있는 i와 j에 경우 i는 d에서 오는 경로와 e에서 오는 경로를 봐야되고
 * j는 e와 f에서 오는 경로를 비교해야한다.
 */

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = -1;

        List<List<Integer>> numbers = new ArrayList<List<Integer>>(500);
        for(int i = 0; i < n; i++){
            numbers.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++){
                numbers.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int y = 0; y < n-1; y++){
            for(int x = 0; x < y+1; x++){
                if(0 == x){
                    numbers.get(y+1).set(0, numbers.get(y+1).get(0) + numbers.get(y).get(0));
                }

                if(x == numbers.get(y).size()-1){
                    numbers.get(y+1).set(x+1, numbers.get(y+1).get(x+1) + numbers.get(y).get(x));
                }

                if(0 < x){
                    if(numbers.get(y).get(x-1) < numbers.get(y).get(x)){
                        numbers.get(y+1).set(x, numbers.get(y+1).get(x) + numbers.get(y).get(x));
                    }else{
                        numbers.get(y+1).set(x, numbers.get(y+1).get(x) + numbers.get(y).get(x-1));
                    }
                }
            }
        }


        for(int i = 0; i < numbers.get(n-1).size(); i++){
            int num = numbers.get(n-1).get(i);
            if(max < num){
                max = num;
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}