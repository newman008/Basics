package LeetCode2;

public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] matrix = new int[m+1][n+1];
        for(int j = 0; j <= n; j++) matrix[0][j] = j;
        for(int i = 0; i <= m; i++) matrix[i][0] = i;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int t = (word1.charAt(i-1) == word2.charAt(j-1) ? 0: 1);
                matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]) + 1, matrix[i-1][j-1] + t);
            }
        }
        
        return matrix[m][n];
    }
}
