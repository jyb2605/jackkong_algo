/*
 * 2020-11-09
 * 용량 부족
 * https://www.acmicpc.net/problem/5446
 *
 * 틀렸다가 질문/검색란에 반례보고 고쳐서 정답됨.
 *
반례
1
2
A
B
0
출력 : 1
 *
 * 메모리 83124kb	시간 512ms
 * 
 * 1. 지워야 하는 파일명 trie에 insert하고 파일명 끝 노드에 단어의 끝을 알리는
 * isLastFileName = true 처리
 *
 * 2. 지우면 안 되는 파일명 trie에 insert하는데(1번과 다른 함수 사용) 거쳐가는
 * 모든 노드에서 isLockedFile = true를 해서 파일명 각 단어의 노드마다 지우면
 * 안되는 것을 적어놓음.
 *
 * 3. trie에 root부터 모든 노드를 순회하는데(dfs) isLockedFile이 false인 node뒤에
 * 나오는 문자열들은 와일드카드 처리가 되므로 cnt++ 해주고 자식 노드 추가 하지 않고
 * continue;
 *
 * 4. 지우면 안되는 파일명의 철자가 포함된 노드이지만 지워야되는 완성된 파일명일
 * 경우(isLoockedFile == true && isLastFileName) cnt++ 해주고 뒤에 문자열도 이어서
 * 봐야 되므로 자식 노드 dfs stack에다가 추가해줌.
 *
 * 5. 1번에서 지워야 하는 파일명에 대한 trie node들이 이미 추가가 된 상태에서
 * 2번 행위를 할 때 한 번도 childern.contains(key)가 true가 되지 않는다면 지워야 하는
 * 파일명에 대해서 지우면 안 되는 파일명이 포함되어 있지 않으므로 단 한번에 *로
 * 모든 파일을 지울 수 있으므로 이 때는 1 출력
 *  - 이 것을 안해서 틀렸음.
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int deleteCommandCnt = 0;
        for(int tCnt = 0; tCnt < t; tCnt++) {
            Trie trie = new Trie();
            int n1 = Integer.parseInt(br.readLine());
            for(int idx = 0; idx < n1; idx++) {
                trie.insertUnlockedFile(br.readLine());
            }

            int n2 = Integer.parseInt(br.readLine());
            for(int idx = 0; idx < n2; idx++) {
                trie.insertLockedFile(br.readLine());
            }
            deleteCommandCnt = trie.canDeleteAllFilesWithOneCommand
                    ? 1
                    : trie.traverse();
            bw.write(Integer.toString(deleteCommandCnt));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

class TrieNode {
    HashMap<Character, TrieNode> childern;
    boolean isLockedFile;
    boolean isLastFileName;

    public TrieNode() {
        this.childern = new HashMap<>();
        this.isLockedFile = false;
        this.isLastFileName = false;
    }
}

class Trie {
    TrieNode root;
    boolean canDeleteAllFilesWithOneCommand;

    public Trie() {
        root = new TrieNode();
        this.canDeleteAllFilesWithOneCommand = true;
    }

    public void insertUnlockedFile(String fileName) {
        TrieNode cur = root;

        for(char key : fileName.toCharArray()) {
            if(!cur.childern.containsKey(key)) {
                cur.childern.put(key, new TrieNode());
            }
            cur = cur.childern.get(key);
        }
        cur.isLastFileName = true;
    }

    public void insertLockedFile(String fileName) {
        TrieNode cur = root;

        for(char key : fileName.toCharArray()) {
            if(cur.childern.containsKey(key)) {
                canDeleteAllFilesWithOneCommand = false;
            } else {
                cur.childern.put(key, new TrieNode());
            }
            cur = cur.childern.get(key);
            cur.isLockedFile = true;
        }
    }

    public int traverse() {
        int deleteCommandCnt = 0;
        TrieNode cur;
        Stack<TrieNode> s = new Stack<>();
        for(Map.Entry<Character, TrieNode> entry : root.childern.entrySet()) {
            s.push(entry.getValue());
        }

        while (!s.isEmpty()) {
            cur = s.pop();
            if(!cur.isLockedFile) {
                deleteCommandCnt++;
                continue;
            } else if(cur.isLastFileName) {
                deleteCommandCnt++;
            }

            for(Map.Entry<Character, TrieNode> entry : cur.childern.entrySet()) {
                s.push(entry.getValue());
            }
        }

        return deleteCommandCnt;
    }
}