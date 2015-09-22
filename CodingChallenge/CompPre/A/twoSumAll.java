package Amazon;

import java.util.*;
/*
 * coding就是2sum和3sum，不过2sum要求输出所有可能的pair，而且原数组可能有duplicate，和LC略有不同。
 */

class Pair {
	int index1;
	int index2;
	
	public Pair(int i, int j) {
		index1 = i;
		index2 = j;		
	}
}

public class twoSumAll {
	
	public List<Pair> twoSum(int[] nums, int target) {
		List<Pair> res = new ArrayList<Pair>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])){
				Pair newPair = new Pair(i, map.get(target - nums[i]));
				res.add(newPair);
			} else {
				map.put(nums[i], i);
			}
		}
		return res;
	}
	
	public List<Pair> twoSumDup(int[] nums, int target) {
		List<Pair> res = new ArrayList<Pair>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				map.get(nums[i]).add(i);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(nums[i], l);
			}
		}
		
//		for(int i = 0; i < nums.length; i++){
//			if(map.containsKey(target - nums[i])) {
//				for(int first : map.get(nums[i])) {
//					for(int second : map.get(target - nums[i])) {
//						if(second > first) {
//							Pair newPair = new Pair(first, second);
//							res.add(newPair);
//						}
//					}
//				}
//			}
//		}
		
		for(int key : map.keySet()){
			if(map.containsKey(target - key)) {
				for(int first : map.get(key)) {
					for(int second : map.get(target - key)) {
						if(second > first) {
							Pair newPair = new Pair(first, second);
							res.add(newPair);
						}
					}
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1 = {2, 3, 4, 5, 1, 6};
//		twoSumAll t = new twoSumAll();
//		for(Pair p : t.twoSum(nums1, 7)){
//			System.out.println(p.index1 + " " + p.index2);
//		}
		/*
		 * 1 -> 0
		 * 2 -> 1, 2
		 * 4 -> 3
		 * 3 -> 4
		 */
		int[] nums2 = {1, 2, 2, 4, 3, 3, 5};
		twoSumAll t = new twoSumAll();
		for(Pair p : t.twoSumDup(nums2, 7)){
			System.out.println(p.index1 + " " + p.index2);
		}
	}

}
