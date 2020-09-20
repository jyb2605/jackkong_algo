import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;

        Arrays.sort(routes, Comparator.comparingInt(o1 -> o1[0]));

        int r = 1;
        int end = routes[0][1];

        while(r < n)
        {
            if(routes[r][0] <= end)
            {
                if(routes[r][1] < end)
                {
                    end = routes[r][1];
                }
                r += 1;
            }
            else
            {
                end = routes[r][1];
                answer += 1;
                r += 1;
            }
        }
        answer += 1;
        return answer;
    }
}