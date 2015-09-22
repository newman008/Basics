package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubStringWithConcatenationOfAllWords {
	public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int numOfWords = words.length;
        int lenOfWord = words[0].length();
        
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        
        for(String w : words) {
            toFind.put(w, toFind.containsKey(w)? toFind.get(w)+1:1);
        }
        
        for(int i = 0; i <= s.length() - numOfWords * lenOfWord; i++) {
            found.clear();
            int j;
            for(j = 0; j < numOfWords; j++) {
                String word = s.substring(i + j * lenOfWord, i + (j+1) * lenOfWord);
                if(!toFind.containsKey(word)) break;
                else {
                    found.put(word, found.containsKey(word)? found.get(word)+1:1);
                }
                if(found.get(word) > toFind.get(word)) break;
            }
            if(j == numOfWords) res.add(i);
        }
        
        return res;
    }
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return res;
        
        int wc = words.length;
        int wl = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        Map<String, Integer> curMap = new HashMap<String, Integer>();
        int count = 0;
        
        for(int i = 0; i < wl; i++) {
            curMap.clear();
            int left = i;
            count = 0;
            for(int j = i; j <= s.length() - wl; j = j + wl) {
                String cur = s.substring(j, j+wl);
                if(map.containsKey(cur)){
                    
                    if(curMap.containsKey(cur)){
                        curMap.put(cur, curMap.get(cur) + 1);
                        if(curMap.get(cur) <= map.get(cur)){
                            count++;
                        } else {
                            while(curMap.get(cur) > map.get(cur)){
                                String str1 = s.substring(left, left+wl);
                                curMap.put(str1, curMap.get(str1) - 1);
                                //if(curMap.get(str1) == 0) curMap.remove(str1);
                                if(!str1.equals(cur)) count--;
                                left += wl;
                            }
                        }
                        
                    } else {
                        curMap.put(cur, 1);
                        count++;
                    }
                    
                    if(count == wc) {
                        res.add(left);
                        String first = s.substring(left, left+wl);
                        curMap.put(first, curMap.get(first) - 1);
                        //if(curMap.get(first) == 0) curMap.remove(first);
                        count--;
                        left += wl;
                    }
                    
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + wl;
                }
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_30_SubStringWithConcatenationOfAllWords t = new _30_SubStringWithConcatenationOfAllWords();
		String s = "cbaccbcbbc";
		String[] words = {"cb","bc"};
		t.findSubstring(s, words);
	}
}
