package LeetCode2;

public class _80_RemoveDupFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int j = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
                count = 1;
            }
            else if(count == 1) {
                nums[j] = nums[i];
                j++;
                count++;
            } else {
                count++;
            }
        }
        return j;
    }
}
