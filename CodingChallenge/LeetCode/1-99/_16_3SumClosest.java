package LeetCode2;

import java.util.Arrays;

public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target) return target;
                if(Math.abs(target - result) > Math.abs(target - sum))
                    result = sum;
                if(sum < target) lo++;
                else 
                    hi --;
            }
        }
        
        return result;
    }
}
