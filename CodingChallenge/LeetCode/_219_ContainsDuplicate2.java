package LeetCode2;

import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }    
        }
        
        return false;
    }
}
