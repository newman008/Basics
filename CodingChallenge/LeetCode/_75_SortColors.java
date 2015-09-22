package LeetCode2;

public class _75_SortColors {
	public void sortColors(int[] nums) {
        // Two pointers
        int j = 0;
        int k = nums.length - 1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                swap(nums, j, i);
                j++;
            }
            else if(nums[i] == 2 && i < k) {
                swap(nums, k, i);
                k--;
                i--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		int[] nums = {2,2};
//    		_75_SortColors.sortColors(nums);
	}
}
