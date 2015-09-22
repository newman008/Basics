package Trie;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();	
	}
	
	public void insert(String s) {
		TrieNode runner = root;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(runner.children[ch - 'a'] == null) {
				runner.children[ch - 'a'] = new TrieNode();
			}
			runner = runner.children[ch - 'a'];
		}
		runner.isEnd = true;
	}
	
	public boolean search(String s) {
		TrieNode runner = root;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(runner.children[ch - 'a'] == null) return false;
			runner = runner.children[ch - 'a'];
		}
		return runner.isEnd;
	}
	
	public boolean startWith(String prefix) {
		TrieNode runner = root;
		for(int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(runner.children[ch - 'a'] == null) return false;
			runner = runner.children[ch - 'a'];
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abcde");
		trie.insert("abcff");
		System.out.println(trie.startWith("abcf"));
		System.out.println(trie.search("abcf"));
		System.out.println(trie.startWith("abc"));
	}
}
