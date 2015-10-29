package InterviewQuestions;

public class WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        if(s == null || p == null || s.length() == 0 || p.length() == 0) return false;
        
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i < m; i++) {
            dp[i][0] = false;
        }
        for(int j = 1; j < n; j++) {
            if(p.charAt(j-1) == '*' && dp[0][j-1]) dp[0][j] = true;
            else dp[0][j] = false;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WildcardMatching t = new WildcardMatching();
        boolean res = t.isMatch("aa", "aa");
    }

}
