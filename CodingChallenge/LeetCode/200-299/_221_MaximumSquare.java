package LeetCode2;

public class _221_MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
        }
        
        for(int j = 0; j < n; j++) {
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    min = Math.min(min, dp[i][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] > max) max = dp[i][j];
            }
        }
        return max * max;
    }
}
