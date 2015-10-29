package LeetCode2;

public class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        int row = s1.length();
        int col = s2.length();
        boolean[][] matrix = new boolean[row+1][col+1];
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(i==0 && j==0) 
                    matrix[i][j] = true;
                else if(i == 0) 
                    matrix[i][j] = matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                else if(j == 0) 
                    matrix[i][j] = matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                else
                    matrix[i][j] = (matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return matrix[row][col];
    }
}
