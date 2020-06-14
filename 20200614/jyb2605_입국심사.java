class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 0, right = 0;

        for(int time : times){
            right = Math.max(right, time);
        }

        right *= n;

        while(left <= right){
            long mid = (left + right) / 2;
            long total = 0;

            for(int time : times){
                total += mid / time;
            }

            if(total < n){
                left = mid + 1;
            }else{
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }

        return answer;
    }
}
