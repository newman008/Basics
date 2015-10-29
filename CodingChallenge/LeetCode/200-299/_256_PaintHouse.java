package LeetCode2;

/*
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
 */

public class _256_PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int m = 3;
            int n = costs.length;
        
            int[][] price = new int[m][n+1];
        
            for(int i = 1; i <= n; i++) {
                price[0][i] = Math.min(price[1][i-1], price[2][i-1]) + costs[i-1][0];
                price[1][i] = Math.min(price[0][i-1], price[2][i-1]) + costs[i-1][1];
                price[2][i] = Math.min(price[0][i-1], price[1][i-1]) + costs[i-1][2];
            }
        
            return Math.min(price[0][n], Math.min(price[1][n], price[2][n]));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
