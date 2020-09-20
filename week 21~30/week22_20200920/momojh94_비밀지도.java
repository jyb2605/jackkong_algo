/*
 * 2020-09-20
 * 2018 kakao [1차]비밀지도
 */

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int encryptedNum1;
        int encryptedNum2;
        int remainder1;
        int remainder2;
        StringBuffer sb = new StringBuffer();
        
        for(int y = 0; y < n; y++) {
            encryptedNum1 = arr1[y];
            encryptedNum2 = arr2[y];
            sb.delete(0, sb.length());
            for(int x = 0; x < n; x++) {
                remainder1 = encryptedNum1 % 2;
                remainder2 = encryptedNum2 % 2;
                encryptedNum1 /= 2;
                encryptedNum2 /= 2;
                if(remainder1 == 1 || remainder2 == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answer[y] = sb.reverse().toString();
        }
        return answer;
    }
}