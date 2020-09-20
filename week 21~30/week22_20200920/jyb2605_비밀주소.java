class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int idx = 0; idx < n; idx++) {
            StringBuilder input = new StringBuilder();
            while(arr1[idx] > 0) {
                if(arr1[idx] % 2 == 1) {
                    input.insert(0, "#");
                }else{
                    input.insert(0, " ");
                }
                arr1[idx]/=2;
            }
            answer[idx] = input.toString();
            while(answer[idx].length() < n) {
                answer[idx] = " " + answer[idx];
            }
        }

        for(int idx = 0; idx < n; idx++) {
            int pos = 0;
            StringBuilder origin;
            while(arr2[idx] > 0) {
                origin = new StringBuilder(answer[idx]);
                if(arr2[idx] % 2 == 1 && answer[idx].charAt(n - pos - 1) == ' '){
                    origin.setCharAt(n - pos - 1, '#');
                    answer[idx] = origin.toString();
                }
                arr2[idx]/=2;
                pos++;
            }
        }

        return answer;
    }
}
