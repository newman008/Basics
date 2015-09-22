package LeetCode2;

public class _132_PalindromePartitioning {
	public int minCut(String s) {
        int l = s.length();
        boolean[][] matrix = new boolean[l][l];
        int[] cut = new int[l];
        
        for(int i = 0; i < l; i++) {
            cut[i] = i;
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j <= 1 || matrix[j+1][i-1])){
                    matrix[j][i] = true;
                    if(j > 0) 
                        cut[i] = Math.min(cut[i], cut[j-1] + 1);
                    else
                        cut[i] = 0;
                }
            }
        }
        
        return cut[l-1];
    }
}
