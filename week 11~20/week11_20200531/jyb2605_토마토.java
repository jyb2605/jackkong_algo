iimport java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner scanner;

    static class Tomato {
        public int x;
        public int y;
        public int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int num = N * M;
        int result = 0;

        int[][] map = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        LinkedList<Tomato> q = new LinkedList<>();

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                map[row][col] = scanner.nextInt();
                if (map[row][col] != 0)
                    num--;
                if (map[row][col] == 1) {
                    q.add(new Tomato(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.pop();

            if (tomato.x > 0 && map[tomato.x - 1][tomato.y] == 0 && !visited[tomato.x - 1][tomato.y]) {
                map[tomato.x - 1][tomato.y] = tomato.day + 1;
                q.add(new Tomato(tomato.x - 1, tomato.y, tomato.day + 1));
                visited[tomato.x - 1][tomato.y] = true;
                num--;
                if(result < tomato.day + 1){
                    result = tomato.day + 1;
                }
            }
            if (tomato.y > 0 && map[tomato.x][tomato.y - 1] == 0 && !visited[tomato.x][tomato.y - 1]) {
                map[tomato.x][tomato.y - 1] = tomato.day + 1;
                q.add(new Tomato(tomato.x, tomato.y - 1, tomato.day + 1));
                visited[tomato.x][tomato.y - 1] = true;
                num--;
                if(result < tomato.day + 1){
                    result = tomato.day + 1;
                }
            }
            if (tomato.x < M - 1 && map[tomato.x + 1][tomato.y] == 0 && !visited[tomato.x + 1][tomato.y]) {
                map[tomato.x + 1][tomato.y] = tomato.day + 1;
                q.add(new Tomato(tomato.x + 1, tomato.y, tomato.day + 1));
                visited[tomato.x + 1][tomato.y] = true;
                num--;
                if(result < tomato.day + 1){
                    result = tomato.day + 1;
                }
            }
            if (tomato.y < N - 1 && map[tomato.x][tomato.y + 1] == 0 && !visited[tomato.x][tomato.y + 1]) {
                map[tomato.x][tomato.y + 1] = tomato.day + 1;
                q.add(new Tomato(tomato.x, tomato.y + 1, tomato.day + 1));
                visited[tomato.x][tomato.y + 1] = true;
                num--;
                if(result < tomato.day + 1){
                    result = tomato.day + 1;
                }
            }
        }

        if(num != 0)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
