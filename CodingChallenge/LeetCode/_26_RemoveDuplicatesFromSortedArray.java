package LeetCode2;

public class _26_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        // int count = 0;
        // for(int i = 1; i < nums.length; i++) {
        //     if(nums[i] == nums[i-1]) count++;
        // }
        // return nums.length - count;
        int j = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
