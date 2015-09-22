package LeetCode2;

public class _53_MaximumSubarray {
	public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(cur < 0) {
                cur = 0;
            }
            
            cur += nums[i];
            max = Math.max(max, cur);
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_53_MaximumSubarray t = new _53_MaximumSubarray();
		int[] nums = {-2, -3, -4, -5, -6};
		System.out.println(t.maxSubArray(nums));
	}
	
}
