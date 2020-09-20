import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int input;
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());

        for(int idx = 0; idx < N; idx++){
            input = Integer.parseInt(st.nextToken());
            if(arr.isEmpty() || arr.get(arr.size() - 1) < input) {
                arr.add(input);
                continue;
            }

            int left = 0, right = arr.size();
            int target = Integer.MAX_VALUE;

            while(left < right){
                int mid = (left + right) / 2;

                if(arr.get(mid) >= input){
                    target = Math.min(target, mid);
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            arr.set(target, input);
        }

        System.out.println(arr.size());
    }
}

