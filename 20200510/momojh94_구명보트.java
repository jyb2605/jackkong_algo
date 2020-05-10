import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        Arrays.sort(people);

        int f = 0;
        int r = n-1;

        boolean[] v = new boolean[n+2];
        Arrays.fill(v, false);

        while(f < n && r >= 0 && f < r) {
            if (v[f]) {
                f += 1;
                continue;
            }

            if (v[r]) {
                r -= 1;
                continue;
            }

            if (people[f] + people[r] > limit)
            {
                answer += 1;
                v[r] = true;
                r -= 1;
            }
            else
            {
                answer += 1;
                v[f] = true;
                v[r] = true;
                f += 1;
                r -= 1;
            }

            if(f == r)
            {
                answer += 1;
                break;
            }
        }

        return answer;
    }
}