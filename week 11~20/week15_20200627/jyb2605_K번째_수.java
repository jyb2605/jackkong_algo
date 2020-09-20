import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long N = Long.parseLong(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long K = Long.parseLong(st.nextToken());
        long answer = Long.MAX_VALUE;

        long left = 1, right = N * N;

        while(left <= right){
            long count = 0;
            long mid = (left + right) / 2;

            for(int num = 1; num <= N; num++){
                count += Math.min(N, mid / num);
            }

            if(count < K){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
