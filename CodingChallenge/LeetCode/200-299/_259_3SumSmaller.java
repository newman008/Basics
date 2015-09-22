package LeetCode2;

/*
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?
 */

import java.util.Arrays;

public class _259_3SumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            // if(i != 0 && nums[i] == nums[i-1]) continue;
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
