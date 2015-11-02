package InterviewQuestions;
/*
There are a row of houses, each house can be painted with three colors red, blue and green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. 
You have to paint the houses with minimum cost. How would you do it? 
Note: Painting house-1 with red costs different from painting house-2 with red. The costs are different for each house and each color.
*/

public class PaintHouseWithColor {
    
    public int miniCost(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;
        int[][] dp = new int[m][n+1];
        
        for(int i = 1; i <= n; i++) {
            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + cost[0][i-1];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + cost[1][i-1];
            dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + cost[2][i-1];
        }
        
        return Math.min(dp[0][n], Math.min(dp[1][n], dp[2][n]));
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] cost = {{7,3,8,6,1,2},{5,6,7,2,4,3},{10,1,4,9,7,6}}; 
        PaintHouseWithColor t = new PaintHouseWithColor();
        System.out.print(t.miniCost(cost));
    }

}
