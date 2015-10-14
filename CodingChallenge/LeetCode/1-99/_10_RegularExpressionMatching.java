package LeetCode2;

public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] matrix = new boolean[m+1][n+1];
        matrix[0][0] = true;
        for(int i = 1; i <= m; i++) {
            matrix[i][0] = false;
        }
        for(int j = 1; j <= n; j++) {
            matrix[0][j] = (j>=2) && p.charAt(j-1) == '*' && matrix[0][j-2];
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j-1) != '*')
                    matrix[i][j] = matrix[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                else
                    matrix[i][j] = matrix[i][j-2] || (matrix[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')); 
            }
        }
        
        return matrix[m][n];
    }
}
