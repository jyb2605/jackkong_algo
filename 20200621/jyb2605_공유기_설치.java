public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int idx = 0; idx < N; idx++){
            st = new StringTokenizer(bf.readLine());
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1, right = arr[N - 1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 1;
            int front = arr[0];

            for(int idx = 1; idx < N; idx++){
                if(arr[idx] - front >= mid){
                    count++;
                    front = arr[idx];
                }
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
