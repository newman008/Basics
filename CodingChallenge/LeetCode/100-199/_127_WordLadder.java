package LeetCode2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        map.put(beginWord, 1);
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
            String word = q.poll();
            if(word.equals(endWord)) break;
            int len = map.get(word);
            
            for(int i = 0; i < word.length(); i++) {
                String tmp = word;
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chrr = tmp.toCharArray();
                    chrr[i] = ch;
                    tmp = new String(chrr);
                    if(wordDict.contains(tmp) && !map.containsKey(tmp)) {
                        map.put(tmp, len+1);
                        q.offer(tmp);
                    }
                }
            }
        }
        
        if(map.get(endWord) == null) return 0;
        else return map.get(endWord);
    }
}
