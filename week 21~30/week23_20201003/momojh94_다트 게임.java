/*
 * 2020-10-03
 * 2018 kakao [1차] 다트 게임
 */

class Solution {
    private static final char SINGLE = 'S';
    private static final char DOUBLE = 'D';
    private static final char TRIPLE = 'T';
    private static final char STAR = '*';
    private static final char OOPS = '#';
    
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[4];
        scores[0] = 0;
        int cur = 1;
        char cmd;
        
        for(int idx = 0; idx < dartResult.length(); idx++) {
            cmd = dartResult.charAt(idx);
            switch(cmd) {
                case '1':
                    if(dartResult.charAt(idx + 1) == '0') {
                        scores[cur++] = 10;
                        idx++;
                    } else {
                        scores[cur++] = 1;
                    }
                    break;
                case SINGLE :
                    break;
                case DOUBLE :
                    scores[cur - 1] *= scores[cur - 1]; 
                    break;
                case TRIPLE :
                    scores[cur - 1] *= scores[cur - 1] * scores[cur - 1];
                    break;
                case STAR :
                    scores[cur - 1] *= 2;
                    scores[cur - 2] *= 2;
                    break;
                case OOPS :
                    scores[cur - 1] *= -1;
                    break;
                default :
                    scores[cur++] = (int)(cmd - 48);
                    break;
            }
        }
        answer = scores[1] + scores[2] + scores[3];
        
        return answer;
    }
}