package LeetCode2;

public class _34_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int[] res = {-1, -1};
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else
                hi = mid;
        }
        if(nums[lo] != target) return res;
        else res[0] = lo;
        
        hi = nums.length - 1;
        while(lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if(nums[mid] > target) hi = mid - 1;
            else
                lo = mid;
        }
        res[1] = hi;
        
        return res;
    }
}
