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
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int idx = 0; idx < N; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = arr[0], max = arr[N - 1];

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        while (N > 0) {
            int number = Integer.parseInt(st.nextToken());
            int answer = Arrays.binarySearch(arr, number);

            if(answer < 0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }

            N--;
        }

    }
}

