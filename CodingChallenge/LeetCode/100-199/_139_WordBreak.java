package LeetCode2;

import java.util.Set;

public class _139_WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l+1];
        dp[0] = true;
        
        for(int i = 1; i <= l; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }
        
        return dp[l];
    }
	
	public boolean wordBreak2(String s, Set<String> wordDict) {
        return helper(s, wordDict, 0);
    }
    
    public boolean helper(String s, Set<String> wordDict, int start) {
        if(start == s.length()) return true;
        
        for(String str : wordDict) {
            int end = start + str.length();
            
            if(end > s.length()) continue;
            
            if(s.substring(start, end).equals(str)) {
                if(helper(s, wordDict, start + str.length()))
                    return true;
            }
        }
        
        return false;
    }
}
