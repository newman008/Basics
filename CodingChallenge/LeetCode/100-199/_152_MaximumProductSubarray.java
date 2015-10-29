package LeetCode2;

public class _152_MaximumProductSubarray {
     public int maxProduct(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            
            int max = nums[0];
            int maxlocal = nums[0];
            int minlocal = nums[0];
            for(int i = 1; i < nums.length; i++) {
                int temp = maxlocal;
                maxlocal = Math.max(nums[i] * maxlocal, Math.max(nums[i] * minlocal, nums[i]));
                minlocal = Math.min(nums[i] * temp, Math.min(nums[i] * minlocal, nums[i]));
                max = Math.max(max, maxlocal);
            }
            return max;
        }
}
