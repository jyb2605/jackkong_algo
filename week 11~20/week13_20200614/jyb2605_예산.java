class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = M / budgets.length;
        int right = 0;

        for(int budget : budgets){
            if(budget > right){
                right = budget;
            }
        }

        int middle = 0;

        while(left <= right){
            int sum = 0;
            middle = (left + right) / 2;

            for(int budget : budgets){
                sum += Math.min(budget, middle);
            }

            if(sum > M){
                right = middle - 1;
            }else{
                answer = middle;
                left = middle + 1;
            }
        }

        return answer;
    }
}
