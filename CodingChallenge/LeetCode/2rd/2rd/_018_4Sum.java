package leetcode;

/** Problem:
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

/** Analysis:
Time  complexity: O()
Space complexity: O()
*/

import java.util.*;

public class _018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null && nums.length == 0) return results;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = nums.length - 1; j > i + 2; j--) {
                if( j != nums.length - 1 && nums[j] == nums[j + 1]) continue;
                int k = i + 1;
                int h = j - 1;
                int sum = target - nums[i] - nums[j];
                while(k < h) {
                    if(nums[k] + nums[h] == sum) {
                        results.add(Arrays.asList(nums[i], nums[k], nums[h], nums[j]));
                        while(k < h && nums[k] == nums[k+1]) k++;
                        while(k < h && nums[h] == nums[h-1]) h--;
                        k++;
                        h--;
                        
                    } else if (nums[k] + nums[h] < sum) {
                        k++;
                    } else {
                        h--;
                    }
                }
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        _018_4Sum s = new _018_4Sum();
        int[] input = new int[]{1, 0, -1, 0, -2, 2};
        Utils.printListOfIntegerList(s.fourSum(input, 0)); 
    } 
}


