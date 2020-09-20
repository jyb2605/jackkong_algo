import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        for(int idx = 0; idx < N; idx++){
            st = new StringTokenizer(bf.readLine());
            arr[idx] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long left = 1, right = arr[N - 1];
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            for(int idx = 0; idx < N; idx++){
                count += arr[idx] / mid;
            }

            if(count >= M){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

