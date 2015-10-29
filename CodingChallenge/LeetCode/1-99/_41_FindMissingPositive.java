package LeetCode2;

public class _41_FindMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i]; 
                nums[i] = temp;
                i--;
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(nums[j] != j+1) return j+1;
        }
        
        return n + 1;
    }
}
