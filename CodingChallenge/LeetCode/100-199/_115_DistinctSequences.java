package LeetCode2;

public class _115_DistinctSequences {
    public int numDistinct(String s, String t) {
        int row = s.length();
        int col = t.length();
        
        int[][] dp = new int[row+1][col+1];
        
        for(int i = 0; i <= row; i++) dp[i][0] = 1;
        
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(s.charAt(i-1) != t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        
        return dp[row][col];
    }
}
