package Trie;
/*
 * Given a string, return its anagrams which are in the existed dictionary
 * Example: "cat" => "act", "tac"
 */

import java.util.*;

public class FindAnagrams {
    
    public static List<String> wordDict = Arrays.asList("abc", "ab", "abcd", "act", "tac", "dog", "dgo", "odg", "ogd", "gdo", "god");
    
    public List<String> findAnagrams(String s) {
        List<String> res = new ArrayList<String>();
        
        for(String str : validAnagrams(s))
            res.add(str);
            
        return res;
    }
    
    private List<String> validAnagrams(String s) {
        List<String> res = new ArrayList<String>();
        char[] chrr = s.toCharArray();
        StringBuilder tmpWord = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        
        Trie trie = new Trie();
        for(String w : wordDict)
            trie.insert(w);
        
        backtrack(res, chrr, tmpWord, visited, trie, 0);
        return res;
    }
    
    // O(n!) n = s.length();
    private void backtrack(List<String> res, char[] chrr, StringBuilder tmpWord, boolean[] visited, Trie trie, int count) {
        if(count == chrr.length) {
            res.add(tmpWord.toString());
            return;
        }
        
        for(int i = 0; i < chrr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                tmpWord.append(chrr[i]);
                if(trie.startWith(tmpWord.toString())) 
                    backtrack(res, chrr, tmpWord, visited, trie, count+1);
                tmpWord.deleteCharAt(tmpWord.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindAnagrams server = new FindAnagrams();
        for(String s : server.findAnagrams("dog"))
            System.out.print(s + " ");
    }

}
