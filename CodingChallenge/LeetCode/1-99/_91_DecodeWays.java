package LeetCode2;

public class _91_DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0)=='0') {  
            return 0;  
        }  
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= len; i++) {
            if(s.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2) != '0') {
                int tmp = Integer.parseInt(s.substring(i-2,i));
                if(tmp > 0 && tmp <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        
        return dp[len];
    }
}
