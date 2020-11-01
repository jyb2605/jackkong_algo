/*
 * 2020-11-01
 * 휴대폰 자판
 * https://www.acmicpc.net/problem/5670
 *
 * trie로 입력으로 들어온 영단어 모두 추가하고 순회하여
 * 순회시 입력 갯수가 추가될 경우 weight + 1 해주고 단어가 완성되는
 * isComplete 일 때 ret += curr.weight으로 전체 입력 갯수 추가해주고
 * 나중에 출력 때 format 으로 소수 두번 째 자리까지 반올림 해서 출력
 * 2일 경우 2.0으로 나오게하면 틀리는 듯 로직 수정 안하고 그대로 하고
 * 출력 포맷만 바꾸니 정답 (System.out.format으로 2.00 나오게하니 정답.)
 * 
 * 들어오는 예제 입력을 보면 eof 처리 해서 while에서 탈출하게 해야 런타임 에러가 안뜸.
 *
 * Scanner -> BufferedReader 입력 방법 수정하니 빨라졌음.
 * 2108ms -> 1068ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution s = new Solution();
        String input;
        while((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            String[] words = new String[n];
            for(int idx = 0; idx < n; idx++) {
                words[idx] = br.readLine();
            }
            System.out.format("%.2f\n", (float) s.solution(words) / n);
        }
    }
}

class TrieNode {
    HashMap<Character, TrieNode> childern;
    boolean isComplete;
    int weight;

    public TrieNode() {
        this.childern = new HashMap<>();
        this.isComplete = false;
        this.weight = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode curr = root;
        for(char key : word.toCharArray()) {
            if (curr.childern.get(key) == null) {
                curr.childern.put(key, new TrieNode());
                curr = curr.childern.get(key);
            } else {
                curr = curr.childern.get(key);
            }
        }
        curr.isComplete = true;
    }

    public int traversal() {
        int ret = 0;
        TrieNode curr;
        TrieNode currChild;
        Queue<TrieNode> q = new LinkedList<>();
        for(Map.Entry<Character, TrieNode> entry : root.childern.entrySet()) {
            curr = entry.getValue();
            curr.weight = 1;
            q.add(curr);
        }
        while(!q.isEmpty()) {
            curr = q.poll();
            if(curr.isComplete) {
                ret += curr.weight;
            }
            for(Map.Entry<Character, TrieNode> childEntry : curr.childern.entrySet()) {
                currChild = childEntry.getValue();
                if(curr.childern.size() == 1) {
                    currChild.weight = curr.weight;
                } else {
                    currChild.weight = curr.weight + 1;
                }
                if(curr.isComplete) {
                    currChild.weight = curr.weight + 1;
                }
                q.add(currChild);
            }
        }

        return ret;
    }
}

class Solution {
    public int solution(String[] words) {
        int ret = 0;
        Trie trie = new Trie();
        for(String word : words) {
            trie.add(word);
        }
        ret = trie.traversal();
        return ret;
    }
}