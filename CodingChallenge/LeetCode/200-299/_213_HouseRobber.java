package LeetCode2;

public class _213_HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob2(nums, 0, nums.length-2), rob2(nums, 1, nums.length-1));
    }
    
    public int rob2(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int l = right - left + 1;
        int[] dp = new int[l+1];
        dp[0] = 0;
        dp[1] = nums[left];
        for(int i = 2; i < l+1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[left + i - 1]);
        }
        
        return dp[l];
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            _213_HouseRobber t = new _213_HouseRobber();
            int[] nums = {0, 0, 0};
        System.out.print(t.rob(nums));
    }
}
