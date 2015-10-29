package LeetCode2;

public class _211_AddAndSearchWord {
    class TrieNode {
        public boolean isLeaf;
        public char c;
        TrieNode[] children = new TrieNode[26];
        
        public TrieNode(char c){
            this.c = c;
        }
        
        public TrieNode() {};
    }
    
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode(ch);
            } 
            node = node.children[ch - 'a'];
            if(i == word.length() - 1) node.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word, root);
    }
    
    private boolean searchNode(String word, TrieNode node) {
        if(node == null) return false;
        if(word.length() == 0) return node.isLeaf;
        
        char ch = word.charAt(0);
        if(ch != '.') {
            return node.children[ch - 'a'] != null && searchNode(word.substring(1), node.children[ch - 'a']);
        } else {
            for(TrieNode tn : node.children) {
                if(searchNode(word.substring(1), tn)) return true;
            }
            return false;
        }
    }
}
