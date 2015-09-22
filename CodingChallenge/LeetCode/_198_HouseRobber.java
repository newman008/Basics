package LeetCode2;

public class _198_HouseRobber {
	public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i-1];
        }
        
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
	
	public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int l = nums.length;
        int[] dp = new int[l+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < l+1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        
        return dp[l];
    }
}
