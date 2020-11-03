/*
 * 2020-11-03
 * 개미굴
 * https://www.acmicpc.net/problem/14725
 *
 * trie이용
 * 
 * 사전 순서가 앞서는 먹이 정보가 먼저 나오는데 Trie를 순회할 때 stack을 사용함으로
 * map에서 entry가 사전 역순으로 참조 되어야 문제에서 원하는 형태처럼 출력할 수 있다.
 * 그래서 TrieNode 내의 childern을 TreeMap 타입으로 하고 Comparator를
 * Collections.reverseOrder()로 사전 역순으로 정렬 되게끔 처리
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        String[] foods = new String[15];
        int k = 0;
        for(int idx = 0; idx < n; idx++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for(int foodIdx = 0; foodIdx < k; foodIdx++) {
                foods[foodIdx] = st.nextToken();
            }
            trie.add(foods, k);
        }
        trie.traversal();
    }
}

class TrieNode {
    int depth;
    TreeMap<String, TrieNode> childern;
    boolean isLeafNode;
    String val;

    public TrieNode(String val, int depth) {
        this.val = val;
        this.depth = depth;
        this.childern = new TreeMap<>(Collections.reverseOrder());
        this.isLeafNode = true;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode("", 0);
    }

    public void add(String[] elements, int len) {
        TrieNode cur = root;
        String key;

        for(int idx = 0; idx < len; idx++) {
            key = elements[idx];
            if(cur.childern.get(key) == null) {
                cur.childern.put(key, new TrieNode(key,cur.depth + 1));
            }
            cur = cur.childern.get(key);
            cur.isLeafNode = false;
        }
        cur.isLeafNode = true;
    }

    public void traversal() {
        Stack<TrieNode> s = new Stack<>();
        TrieNode cur;
        StringBuilder sb;
        for(Map.Entry<String, TrieNode> entry : root.childern.entrySet()) {
            s.add(entry.getValue());
        }

        while (!s.isEmpty()) {
            sb = new StringBuilder();
            cur = s.pop();

            for(int multiple = 0; multiple < cur.depth - 1; multiple++) {
                sb.append("--");
            }
            sb.append(cur.val);
            System.out.println(sb.toString());

            for(Map.Entry<String, TrieNode> entry : cur.childern.entrySet()) {
                s.add(entry.getValue());
            }
        }
    }
}