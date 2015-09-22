package LeetCode2;

/*
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
 */

public class _265_PaintHouse2 {
	
	public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

	    	int m = costs.length; // house
	    	int n = costs[0].length; // color
        
        if(m == 1 && n == 1) return costs[0][0];
	    	int[][] dp = new int[m+1][n];
	    
	    	int firstSmall = 0;
	    	int secondSmall = 0;
	    	int firstIndex = 0;
	    	int secondIndex = 1;
	    
	    	for(int i = 1; i <= m; i++) {
	    		for(int j = 0; j < n; j++) {
	    			if(j == firstIndex) dp[i][j] = costs[i-1][j] + secondSmall;
	    			else dp[i][j] = costs[i-1][j] + firstSmall;
	    		}
	    
	    		firstSmall = dp[i][0];
	    		firstIndex = 0;
	    		secondSmall = dp[i][1];
	    		secondIndex = 1;
	    		for(int k = 2; k < n; k++) {
	    			if(dp[i][k] < firstSmall) {
	    			    secondSmall = firstSmall;
	    			    secondIndex = firstIndex;
	    				firstSmall = dp[i][k];
	    				firstIndex = k;
	    			} else if(dp[i][k] >= firstSmall && dp[i][k] < secondSmall) {
	    				secondSmall = dp[i][k];
	    				secondIndex = k;
	    			} 
	    		}
	    	}
	    
	    	return firstSmall;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_265_PaintHouse2 t = new _265_PaintHouse2();
		int[][] costs = {{3,14,12,2,20,16,12,2},
		                  {9,6,9,8,2,9,20,18},
		                  {20,2,20,4,5,12,11,11},
		                  {16,3,7,5,15,2,2,4},
		                  {17,3,11,1,9,5,7,11}};
		t.minCostII(costs);
	}

}
