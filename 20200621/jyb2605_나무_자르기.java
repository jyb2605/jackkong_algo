import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());

        int left = 0, right = 0;
        for(int idx = 0; idx < N; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[idx]);
        }

        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;

            for(int idx = 0; idx < N; idx++){
                int tmp = arr[idx] - mid;
                sum += Math.max(tmp, 0);
            }

            if(sum >= M){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
