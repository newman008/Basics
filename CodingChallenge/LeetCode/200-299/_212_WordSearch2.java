package LeetCode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _212_WordSearch2 {
    class TrieNode {
        // Initialize your data structure here.
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode runner = root;
            for(char c : word.toCharArray()) {
                if(runner.children[c - 'a'] == null) {
                    runner.children[c - 'a'] = new TrieNode();
                }
                runner = runner.children[c - 'a'];
            }
            runner.isEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode runner = root;
            for(char c : word.toCharArray()) {
                if(runner.children[c - 'a'] == null) {
                    return false;
                } else {
                    runner = runner.children[c - 'a'];
                }
            }
            return runner.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode runner = root;
            for(char c : prefix.toCharArray()) {
                if(runner.children[c - 'a'] == null) {
                    return false;
                } else {
                    runner = runner.children[c - 'a'];
                }
            }
            return true;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0 || board == null || board.length == 0) return res;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        Trie t = new Trie();
        for(String word : words) {
            t.insert(word);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                search(res, board, words, t, visited, i, j, new StringBuilder());
            }
        }
        
        HashSet hs = new HashSet();
        hs.addAll(res);
        res.clear();
        res.addAll(hs);
        return res;
    }
    
    private void search(List<String> res, char[][] board, String[] words, Trie t, boolean[][] visited, int i, int j, StringBuilder sb) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        
        sb.append(board[i][j]);
        String str = sb.toString();
        visited[i][j] = true;
        if(t.startsWith(str)) {
            if(t.search(str)) res.add(str);
            
            search(res, board, words, t, visited, i-1, j, sb);
            search(res, board, words, t, visited, i+1, j, sb);
            search(res, board, words, t, visited, i, j-1, sb);
            search(res, board, words, t, visited, i, j+1, sb);
        }
        
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
