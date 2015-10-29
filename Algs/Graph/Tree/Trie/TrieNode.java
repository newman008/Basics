package Trie;

public class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    
    public TrieNode() {
        this.isEnd = false;
        children = new TrieNode[26];
    }
}
