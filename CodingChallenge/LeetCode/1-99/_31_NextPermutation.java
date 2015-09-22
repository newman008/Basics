package LeetCode2;

import java.util.Arrays;

public class _31_NextPermutation {
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int len = nums.length;
        boolean flag = true;
        
        for(int i = len - 2; i >=0; i--) {
            if(nums[i] < nums[i+1]) {
                flag = false;
                for(int j = len - 1; j >= i; j--) {
                    if(nums[j] > nums[i]) {
                        swap(nums, i, j);
                        break;
                    }
                }
                Arrays.sort(nums, i+1, len);
                break;
            }
        }
        
        if(flag) Arrays.sort(nums);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
