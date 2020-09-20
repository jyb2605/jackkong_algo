import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner  = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int result = 0;
        Stack<Integer> s = new Stack<>();

        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for(int idx = 0; idx < N + 1; idx++){
            adj.add(new ArrayList<Integer>());
        }

        int num = 0;
        while(num < M){
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            adj.get(A-1).add(B - 1);
            adj.get(B-1).add(A - 1);
            num++;
        }

        for(int idx = 0; idx < N; idx++){
            if(visited[idx])
                continue;
            visited[idx] = true;
            s.push(idx);

            while(s.size() > 0){
                int front = s.peek();
                boolean isPush = false;

                for(int idx2 = 0; idx2 < adj.get(front).size(); idx2++){
                    if(!visited[adj.get(front).get(idx2)]){
                        visited[adj.get(front).get(idx2)] = true;
                        s.push(adj.get(front).get(idx2));
                        isPush = true;
                        break;
                    }
                }

                if(!isPush){
                    s.pop();
                }
            }

            result++;
        }

        System.out.println(result);
    }
}

