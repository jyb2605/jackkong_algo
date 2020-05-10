import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        int sum = 0;
        int n = weight.length;
        Arrays.sort(weight);
        for(int i = 0; i < n; i++)
        {
            if(sum + 1 < weight[i])
            {
                break;
            }
            sum += weight[i];
        }
        answer = sum + 1;
        return answer;
    }
}