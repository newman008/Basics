package LeetCode2;

import java.util.TreeSet;

public class _220_ContainsDoulicates3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if((set.floor(nums[i]) != null && nums[i] <= set.floor(nums[i]) + t) || (set.ceiling(nums[i]) != null && nums[i] >= set.ceiling(nums[i]) - t))
                return true;
            
            set.add(nums[i]);
            if(i >= k) set.remove(nums[i-k]);
        }
        
        return false;
    }
}
