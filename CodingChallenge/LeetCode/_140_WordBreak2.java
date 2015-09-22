package LeetCode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _140_WordBreak2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        int len = s.length();
        boolean[] canDivide = new boolean[len+1];
        canDivide[0] = true;
        
        for(int i = 1; i <= len; i++) {
        		for(int j = 0; j < i; j++) {
        			if(canDivide[j] && wordDict.contains(s.subSequence(j, i)))
        				canDivide[i] = true;
        		}
        }
        
        if(!canDivide[len]) return res; 
        
        backtrack(s, wordDict, res, sb, 0);
        return res;
    }
    
    private void backtrack(String s, Set<String> wordDict, List<String> res, StringBuilder sb, int start) {
        if(start >= s.length()) {
            res.add(sb.toString());
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(wordDict.contains(str)) {
                int preL = sb.length();
                if(preL != 0) sb.append(" ");
                sb.append(str);
                backtrack(s, wordDict, res, sb, i);
                sb.delete(preL, sb.length());
            }
        }
    }
}
