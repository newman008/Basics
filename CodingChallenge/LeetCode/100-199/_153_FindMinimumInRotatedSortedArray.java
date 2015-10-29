package LeetCode2;

public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            if(nums[lo] < nums[hi])
                return nums[lo];
            
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return Math.min(nums[lo], nums[hi]);
    }
    
    public int findMin2(int[] nums) {
        return findMin2(nums, 0, nums.length-1);
    }
    
    private int findMin2(int[] nums, int lo, int hi) {
        if(lo == hi) return nums[lo];
        if(lo == hi-1) return Math.min(nums[lo], nums[hi]);
        
        int mid = (lo+hi) / 2;
        // not rotated
        if(nums[lo] < nums[hi]) return nums[lo];
        
        if(nums[mid] < nums[hi]) return findMin2(nums, lo, mid);
        else return findMin2(nums, mid, hi);
    }
}
