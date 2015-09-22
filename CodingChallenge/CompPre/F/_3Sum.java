package Facebook;

import java.util.*;

// 1. 3sum , 题目还变得更简单了，找到任意3个数和为0，每个数可重复使用。
// 根本不需要两个指针，上hashmap妥妥的。
// follow up： 如果是找任意k个数和为0呢？

public class _3Sum {
	
	public List<List<Integer>> kSum(int[] nums, int k) {
		Arrays.sort(nums);
		return kSum(nums, k, 0, 0);
	}
	
	public List<List<Integer>> kSum(int[] nums, int k, int target, int start) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(k == 0) {
			if(target == 0) {
				res.add(new ArrayList<Integer>());
				return res;
			}
			return res;
		}
		
		for(int i = start; i < nums.length - k + 1; i++) {
			if(i > start && nums[i] == nums[i-1]) continue;
			for(List<Integer> list : kSum(nums, k-1, target-nums[i], i+1)){
				list.add(0, nums[i]);
				res.add(list);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3Sum t = new _3Sum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = t.kSum(nums, 4);
		for(List<Integer> l : res) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
