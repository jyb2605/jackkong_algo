/*
 * 2020-10-03
 * 2018 kakao [1차] 프렌즈 4 블록

1. 2x2 블록의 좌측 상단 좌표 찾기(queue로 리턴) 
2. 1번에서 찾은 좌표에서 2x2 매칭되는 블록 제거하면서 count 증가 체크
3. 블록 빈칸 채우기

1~3 무한 반복 하면서 1번에서 나온 queue가 비면 반복문 탈출 하고 answer 리턴 

 */

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static final char EMPTY = '@';
    private static final int POS_X = 0;
    private static final int POS_Y = 1;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                map[y][x] = board[y].charAt(x);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        while(true) {
            q = getMatched2x2BlockTopLeftPositions(map, m, n);
            if(q.isEmpty()) {
                break;
            }
            answer += remove2x2Blocks(map, q);
            fillBlocks(map, m, n);
        }
        
        return answer;
    }
    
    public Queue<int[]> getMatched2x2BlockTopLeftPositions(char[][] map, int row, int col) {
        Queue<int[]> ret = new LinkedList<>();
        char blockType;
        
        for(int y = 0; y < row - 1; y++) {
            for(int x = 0; x < col - 1; x++) {
                blockType = map[y][x];
                if(blockType != EMPTY  && blockType == map[y][x + 1] &&
                   blockType == map[y + 1][x] && blockType == map[y + 1][x + 1]){
                    ret.add(new int[]{x, y});
                }
            }
        }
        
        return ret;
    }
    
    public int remove2x2Blocks(char[][] map, Queue<int[]> topLeftPosQueue) {
        int ret = 0;
        int[] topLeftPos;
        while(!topLeftPosQueue.isEmpty()) {
            topLeftPos = topLeftPosQueue.poll();
            for(int y = 0; y < 2; y++) {
                for(int x = 0; x < 2; x++) {
                    if(map[topLeftPos[POS_Y] + y][topLeftPos[POS_X] + x] != EMPTY) {
                        map[topLeftPos[POS_Y] + y][topLeftPos[POS_X] + x] = EMPTY;
                        ret++;
                    }
                }
            }
        }
        
        return ret;
    }
    
    public void fillBlocks(char[][] map, int row, int col) {
        for(int y = row - 1; y > 0; y--) {
            for(int x = 0; x < col; x++) {
                if(map[y][x] == EMPTY) {
                    for(int upstairs = y - 1; upstairs >= 0; upstairs--) {
                        if(map[upstairs][x] != EMPTY) {
                            map[y][x] = map[upstairs][x];
                            map[upstairs][x] = EMPTY;
                            break;
                        }
                    }
                }
            }
        }
    }
}