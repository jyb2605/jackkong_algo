/*
 * 2020-05-30
 * https://www.acmicpc.net/problem/1018
 *
 */

import java.util.*;

public class Main {
    //private static final char BLACK = 'B';
    private static final char WHITE = 'W';
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        int answer = 10000000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int repaintSize;
        String[] map = new String[51];

        for (int i = 0; i < n; i++) {
                map[i] = sc.next();
        }

        for (int y = 0; y <= n - BOARD_SIZE; y++) {
            for (int x = 0; x <= m - BOARD_SIZE; x++) {
                repaintSize = repaintChessBoardSize(map, x, y);
                if(answer > repaintSize){
                    answer = repaintSize;
                }
            }
        }
        System.out.println(answer);
    }

    public static int repaintChessBoardSize(String[] map, int startX, int startY){
        int blackStandard = 0;
        int whiteStandard = 0;
        int tx, ty;
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                tx = startX + x;
                ty = startY + y;

                if(0 == y % 2){
                    if(0 == x % 2){
                        if(WHITE == map[ty].charAt(tx)){
                            blackStandard += 1;
                        }
                        else{
                            whiteStandard += 1;
                        }
                    }
                    else{
                        if(WHITE == map[ty].charAt(tx)){
                            whiteStandard += 1;
                        }
                        else{
                            blackStandard += 1;
                        }
                    }
                }
                else{
                    if(0 == x % 2){
                        if(WHITE == map[ty].charAt(tx)){
                            whiteStandard += 1;
                        }
                        else{
                            blackStandard += 1;
                        }
                    }
                    else{
                        if(WHITE == map[ty].charAt(tx)){
                            blackStandard += 1;
                        }
                        else{
                            whiteStandard += 1;
                        }
                    }
                }
            }
        }
        return blackStandard < whiteStandard ? blackStandard : whiteStandard;
    }
}