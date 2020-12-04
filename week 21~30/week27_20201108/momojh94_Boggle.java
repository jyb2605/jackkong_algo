/*
 * 2020-11-08
 * Boggle
 * https://www.acmicpc.net/problem/9202
 *
 * trie
 *
 * 메모리		시간
 * 487096kb	6380ms
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Solution s = new Solution();

        int w = Integer.parseInt(br.readLine());
        String[] words = new String[w];
        String word;
        HashSet<Character> firstChars = new HashSet<>();
        for(int idx = 0; idx < w; idx++) {
            word = br.readLine();
            words[idx] = word;
            firstChars.add(word.charAt(0));
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        char[][] grid = new char[4][4];
        for(int idx = 0; idx < b; idx++) {
            for(int row = 0; row < 4; row++) {
                word = br.readLine();
                for(int col = 0; col < 4; col++) {
                    grid[row][col] = word.charAt(col);
                }
            }
            bw.write(s.solution(firstChars, words, grid));
            bw.newLine();
            if(idx < b - 1) {
                br.readLine();
            }
        }

        bw.flush();
        bw.close();
    }
}

class Solution {
    private static final int[] SCORES = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    public String solution(HashSet<Character> firstChars, String[] words, char[][] grid) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> ansStrings = new HashMap<>();
        Trie trie = new Trie();
        int scoreTotal = 0;
        String longStr = "";
        int searchedWordsCnt = 0;

        for(int y = 0; y < 4; y++) {
            for(int x = 0; x < 4; x++) {
                if(firstChars.contains(grid[y][x])) {
                    trie.addFirstChar(grid[y][x], x, y);
                }
            }
        }

        for(String word : words) {
            if(ansStrings.containsKey(word)) {
                ansStrings.put(word, ansStrings.get(word) + 1);
            } else if(trie.search(word, grid)) {
                ansStrings.put(word, 1);
            }
        }

        for(Map.Entry<String, Integer> entry : ansStrings.entrySet()) {
            scoreTotal += SCORES[entry.getKey().length()] * entry.getValue();
            searchedWordsCnt += entry.getValue();
            if(longStr.length() < entry.getKey().length()) {
                longStr = entry.getKey();
            } else if(longStr.length() == entry.getKey().length()) {
                longStr = longStr.compareTo(entry.getKey()) < 0 ? longStr : entry.getKey();
            }
        }

        sb.append(scoreTotal);
        sb.append(" ");
        sb.append(longStr);
        sb.append(" ");
        sb.append(searchedWordsCnt);
        return sb.toString();
    }
}

class TrieNode {
    List<TrieNode>[] childern;
    boolean isLeafNode;
    int depth;
    int x;
    int y;

    public TrieNode() {
        this.childern = new ArrayList[26];
        this.isLeafNode = true;
        this.depth = 0;
        this.x = -1;
        this.y = -1;
    }

    public TrieNode(int depth) {
        this();
        this.depth = depth;
    }

    public TrieNode(int depth, int x, int y) {
        this();
        this.depth = depth;
        this.x = x;
        this.y = y;
    }
}

class Trie {
    private static final int[][] SEARCHING_POS =
            {{-1, -1}, {0, -1}, {1, -1}
                    , {-1, 0}, {1, 0}
                    , {-1, 1}, {0, 1}, {1, 1},
            };

    TrieNode root;

    public Trie() {
        root = new TrieNode(-1);
    }

    public void addFirstChar(char c, int x, int y) {
        int idx = c - 'A';
        if(root.childern[idx] == null) {
            root.childern[idx] = new ArrayList<>();
        }
        root.childern[idx].add(new TrieNode(0, x, y));
    }

    public boolean search(String word, char[][] grid) {
        boolean[][] visited = new boolean[4][4];
        TrieNode cur = root;
        int charIdx = word.charAt(0) - 'A';
        if(cur.childern[charIdx] == null) {
            cur.childern[charIdx] = new ArrayList<>();
        }
        for(int idx = 0; idx < cur.childern[charIdx].size(); idx++) {
            if(serachRecursion(visited, cur.childern[charIdx].get(idx), word, grid)) {
                return true;
            };
        }
        return false;
    }

    public boolean serachRecursion(boolean[][] visited, TrieNode cur, String word, char[][] grid) {
        visited[cur.y][cur.x] = true;
        if(cur.depth == word.length() - 1) {
            return true;
        }
        char nextChar = word.charAt(cur.depth + 1);
        int charIdx = nextChar - 'A';
        if(cur.childern[charIdx] == null) {
            cur.childern[charIdx] = new ArrayList<>();
        }
        List<TrieNode> childern = cur.childern[charIdx];
        int nextX = 0;
        int nextY = 0;
        if(childern.size() == 0) {
            for(int searchingPosIdx = 0; searchingPosIdx < 8; searchingPosIdx++) {
                nextX = cur.x + SEARCHING_POS[searchingPosIdx][0];
                nextY = cur.y + SEARCHING_POS[searchingPosIdx][1];
                if(0 <= nextX && nextX < 4 && 0 <= nextY && nextY < 4 &&
                    !visited[nextY][nextX] && nextChar == grid[nextY][nextX]) {
                    childern.add(new TrieNode(cur.depth + 1, nextX, nextY));
                }
            }
        }
        for(int idx = 0; idx < childern.size(); idx++) {
            if(serachRecursion(visited, childern.get(idx), word, grid)) {
                return true;
            };
        }
        visited[cur.y][cur.x] = false;
        return false;
    }
}