package LeetCode2;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int l = nums.length;
		
		for(int i = 0; i < l-2; i++) {
			if(i==0 || nums[i] != nums[i-1]) {
				int lo = i+1, hi = l-1;
				while(lo < hi) {
					if(nums[lo] + nums[hi] == -nums[i]) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while(lo < hi && nums[lo] == nums[lo+1]) lo++;
						while(lo < hi && nums[hi] == nums[hi-1]) hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < -nums[i])
						lo++;
					else
						hi--;
				}
			}
		}
		
		return res;
    }
}
