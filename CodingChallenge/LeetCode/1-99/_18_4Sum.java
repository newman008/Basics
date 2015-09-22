package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            
            for(int l = nums.length-1; l >= i+3; l--) {
                if(l != nums.length-1 && nums[l] == nums[l+1]) continue;
                
                int j = i + 1;
                int k = l - 1;
                int sum = target - nums[i] - nums[l];
                
                while(j < k) {
                    if(j > i + 1 && nums[j] == nums[j-1]) {
                        j++;
                        continue;
                    }
                    if(k < l - 1 && nums[k] == nums[k+1]) {
                        k--;
                        continue;
                    }
                    
                    if(nums[j] + nums[k] == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < sum)
                        j++;
                    else
                        k--;
                }
            }
        }
        return res;
    }
}
