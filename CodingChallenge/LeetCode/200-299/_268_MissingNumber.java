package LeetCode2;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i] && nums[i] >= 0 && nums[i] < nums.length){
                swap(nums, i, nums[i]);
                i--;
            }
        }
        
        int missIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i]) return i;
        }
        
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
