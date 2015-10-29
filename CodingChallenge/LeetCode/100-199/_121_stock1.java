package LeetCode2;

public class _121_stock1 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        
        int max = 0;
        int miniPrice = prices[0];
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < miniPrice) miniPrice = prices[i];
            max = Math.max(max, prices[i] - miniPrice);
        }
        
        return max;
    }
}
