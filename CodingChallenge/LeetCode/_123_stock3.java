package LeetCode2;

public class _123_stock3 {
	public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = 0;
        int miniprice = prices[0];
        for(int i = 1; i < len; i++) {
            if(prices[i] < miniprice) miniprice = prices[i];
            left[i] = Math.max(left[i-1], prices[i] - miniprice);
        }
        
        right[len - 1] = 0;
        int maxprice = prices[len-1];
        for(int i = len-2; i >= 0; i--) {
            if(prices[i] > maxprice) maxprice = prices[i];
            right[i] = Math.max(right[i+1], maxprice - prices[i]);
        }
        
        int profit = 0;
        for(int i = 0; i < len; i++) {
            profit = Math.max(profit, left[i]+right[i]);
        }
        
        return profit;
    }
}
