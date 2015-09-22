package LeetCode2;

public class _188_stock4 {
	public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);
        int[][] dp = new int[k+1][prices.length];
        //int[][] local = new int[k+1][prices.length];
        
        for(int i = 1; i <= k; i++) {
            int tmp = -prices[0]; 
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmp);
                tmp = Math.max(tmp, dp[i-1][j-1] - prices[j]);
            }
        }
        
        return dp[k][prices.length-1];
    }
	
	public int maxProfit2(int k, int[] prices) {
        if(prices.length == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);
        int[][] global = new int[prices.length][k+1];
        int[][] local = new int[prices.length][k+1];
        
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff,0), local[i-1][j] + diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        
        return global[prices.length-1][k];
    }
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
