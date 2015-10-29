package LeetCode2;

/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class _238_ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        
        int l = nums.length;
        int[] res = new int[l];
        for(int i = 0; i < l; i++)
            res[i] = 1;
        
        for(int i = 1; i < l; i++)
            res[i] = res[i-1] * nums[i-1];
        
        int tmp = 1;
        for(int i = l-1; i >= 0; i--) {
            res[i] = res[i] * tmp;
            tmp = tmp * nums[i];
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
