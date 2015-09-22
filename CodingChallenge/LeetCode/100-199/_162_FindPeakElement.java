package LeetCode2;

public class _162_FindPeakElement {
	public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }
    
    private int findPeak(int[] nums, int lo, int hi) {
        if(lo == hi) return lo;
        if(hi - lo == 1) return nums[lo] > nums[hi] ? lo : hi;
        
        int mid = (lo + hi) / 2;
        if(nums[mid] < nums[mid-1]) 
            return findPeak(nums, lo, mid);
        else 
            return findPeak(nums, mid, hi);
    }
    
    public int findPeakElement2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            if(hi - lo == 1) return nums[lo] > nums[hi] ? lo : hi;
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[mid-1]) hi = mid;
            else 
                lo = mid;
        }
        
        return lo;
    }
}
