/*
 * 2020-11-01
 * 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 *
 * trie
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        Solution s = new Solution();
        int tMax = Integer.parseInt(br.readLine());
        for(int t = 0; t < tMax; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneBook = new String[n];
            for(int idx = 0; idx < n; idx++) {
                phoneBook[idx] = br.readLine();
            }
            bw.write(s.solution(phoneBook));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

class TrieNode {
    int childernCnt;
    TrieNode[] childern;
    boolean isLeafNode;

    public TrieNode() {
        this.childernCnt = 0;
        this.childern = new TrieNode[10];
        this.isLeafNode = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public boolean addNode(String numStr) {
        TrieNode curr = root;
        int idx = 0;
        for(char c : numStr.toCharArray()) {
            idx = c - '0';
            if(curr.childern[idx] == null) {
                curr.childernCnt++;
                curr.childern[idx] = new TrieNode();
                curr = curr.childern[idx];
            } else {
                curr = curr.childern[idx];
                if(curr.isLeafNode) {
                    return false;
                }
            }
        }
        if(curr.childernCnt > 0) {
            return false;
        }
        curr.isLeafNode = true;

        return true;
    }
}

class Solution {
    public String solution(String[] phoneBook) {
        String ret = "YES";
        Trie trie = new Trie();
        for(String numStr : phoneBook) {
            if(trie.addNode(numStr) == false) {
                ret = "NO";
                break;
            }
        }
        return ret;
    }
}