package leetcode;

/** Problem:
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

/** Analysis:
Time  complexity: O(NLogN + N^2)
Space complexity: O(1)
*/

import java.util.*;

public class _015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return results;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            
            int lo = i + 1;
            int hi = nums.length - 1;
            int target = -nums[i];
            while(lo < hi) {
                if(nums[lo] + nums[hi] < target) {
                    lo++;
                } else if(nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        _015_3Sum s = new _015_3Sum();
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        Utils.printListOfIntegerList(s.threeSum(input));
    } 
}


