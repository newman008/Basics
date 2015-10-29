package lintCode;

public class CopyBooks {
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int[][] dp = new int[k][pages.length];
        int sum = 0;
        int max = 0;
        for(int j = 0; j < pages.length; j++) {
            sum += pages[j];
            dp[0][j] = sum;
            max = Math.max(max, pages[j]);
        }
        
        for(int i = 0; i < k; i++) {
            dp[i][0] = pages[0];
        }
        
        if(k >= pages.length) return max;
        
        // dp[i][j] = Min(max(dp[i-1][t], sum(t+1, j))), 1<=i<=k, 0 <= j < n, 0 <= t < j
        for(int i = 1; i < k; i++) {
            for(int j = 1; j < pages.length; j++) {
                for(int t = j-1; t >= 0; t--) {
                    int cur = Math.max(dp[i-1][t], dp[0][j] - dp[0][t]);
                    dp[i][j] = Math.min(cur, dp[i][j]);
                }
            }
        }
        
        return dp[k-1][pages.length - 1];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CopyBooks t = new CopyBooks();
        int[] pages = {3, 2, 4};
        t.copyBooks(pages, 2);
    }

}
