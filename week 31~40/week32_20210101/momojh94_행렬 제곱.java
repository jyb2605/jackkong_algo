/*
 * 2021-01-02
 * 행렬 제곱
 * https://www.acmicpc.net/problem/10830
 * 분할 정복
 *
 * 1. 런타임 에러
 * long b = Integer.parseInt(st.nextToken());
 * long 타입인데 Integer parseInt로 적어서 에러 남
 *
 * 2. 80%에서 틀림
 * % 연산 하는게 행렬 곱 할 때 있어서 b가 1일 때 %연산을 안해서 틀림.
 * 행렬 입력 값 처음 matrix 배열에 넣을 때 % 1000 해서 대입
 * 반례
2 1
1000 1000
1000 1000
답
0 0
0 0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = divide(matrix, b);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                bw.write(Integer.toString(answer[row][col]));
                bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int[][] divide(int[][] matrix, long b) {
        if(b == 1) {
            return matrix;
        }

        int[][] result = divide(matrix, b / 2);
        result = multiplyMatrix(result, result);
        if(b % 2 == 1) {
            result = multiplyMatrix(result, matrix);
        }

        return result;
    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int i = 0; i < n; i++) {
                    result[row][col] += matrix1[row][i] * matrix2[i][col];
                }
                result[row][col] %= 1000;
            }
        }

        return result;
    }
}