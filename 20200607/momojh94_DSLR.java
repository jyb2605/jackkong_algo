/*
 * 2020-06-
 * https://www.acmicpc.net/problem/9019
 * 백준 DSLR (bfs)
 * 
 * 메모리 초과
 *  -> boolean[] visit 만들어서 중복 방문 방지
 * 시간초과
 *  -> %연산 때문인가 해서 % 빼고 계산했으나 그대로 시간초과
 * 질문글들 보다가 해결함.
 * 처음 풀 때는 노드 방문 처리를 (visit[숫자] = true;) q에서 poll하고 바로 다음에 해줬는데 DSLR 명령어 처리하고 각각 숫자들 visit 체크하고 큐에 넣기 전에 해줘야 q에 같은 숫자 여러 번 추가 될 가능성 방지되서 시간초과 해결
 *
 * 다른 테스트 케이스
 *
2
0255 0777
1000 2555
 *
 * SLSLSSSDS
 * SDRDDRSDS
 */

import java.io.*;
import java.util.*;

class Main {
    private static final char[] COMMAND = new char[]{'D', 'S', 'L', 'R'};

    public static class Pair<F, S> {
        F first;
        S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    private static String answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int initialNum;
        int targetNum;
        boolean[] visit = new boolean[10001];

        for(int i = 0; i < t; i++)
        {
            st = new StringTokenizer(br.readLine());
            initialNum = Integer.parseInt(st.nextToken());
            targetNum = Integer.parseInt(st.nextToken());
            Arrays.fill(visit, 0, 10000, false);
            bfs(visit, initialNum, targetNum);
            bw.write(answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(boolean[] visit, int initialNum, int targetNum) {
        Queue<Pair<Integer, StringBuilder>> q = new LinkedList<>();
        q.add(new Pair<>(initialNum, new StringBuilder()));
        visit[initialNum] = true;
        Pair<Integer, StringBuilder> node;
        int[] num = new int[4];
        StringBuilder sb = null;
        while(!q.isEmpty()) {
            node = q.poll();

            // DSLR cmd
            num[0] = (node.first * 2) % 10000;
            num[1] = (node.first + 9999) % 10000;
            num[2] = (node.first % 1000) * 10 + (node.first / 1000);
            num[3] = (node.first % 10) * 1000 + (node.first / 10);

            for (int i = 0; i < 4; i++) {
                if(!visit[num[i]]){
                    visit[num[i]] = true;
                    sb = new StringBuilder(node.second);
                    sb.append(COMMAND[i]);
                    if (num[i] == targetNum) {
                        answer = sb.toString();
                        return;
                    }
                    q.add(new Pair<>(num[i], sb));
                }
            }
        }
    }
}
