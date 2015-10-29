package LeetCode2;

public class _189_RotateArray {
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int l = nums.length;
        int[] tmp = new int[l];
        for(int i = 0; i < k; i++) {
            tmp[i] = nums[l-k+i];
        }
        for(int i = k; i < l; i++) {
            tmp[i] = nums[i-k];
        }
        for(int i = 0; i < l; i++) {
            nums[i] = tmp[i];
        }
    }
    
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        reverse(nums, 0, l-1-k);
        reverse(nums, l-k, l-1);
        reverse(nums, 0, l-1);
    }
    
    private void reverse(int[] nums, int lo, int hi) {
        while(lo < hi) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
    
}
