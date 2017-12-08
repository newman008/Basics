package leetcode;

/** Problem: 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/** Analysis:
Time  complexity: O(N)
Space complexity: O(N)
*/

import java.util.*;

public class _001_two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
 	_001_two_sum s = new _001_two_sum();
	int[] input = new int[]{2, 3, 6, 15};
	int[] res = s.twoSum(input, 9);
        Utils.printIntArray(res);
    }
}
