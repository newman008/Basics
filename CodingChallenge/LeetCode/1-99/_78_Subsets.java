package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(results, res, 0, nums);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> res, int index, int[] nums) {
        if(index == 1<<nums.length) {
            return;
        }
        
        for(int j = 0; j < nums.length; j++) {
            if((index & 1<<j) != 0) res.add(nums[j]);
        }
        
        results.add(res);
        
        res = new ArrayList<Integer>();
        backtrack(results, res, index+1, nums);
    }
    
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        
        for(int i = 0; i < (2 << nums.length); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for(int j = 0; j < nums.length; j++) {
                if(((i >> j) & 1) != 0) subset.add(nums[j]);
            }
            res.add(subset);
        }

        return res;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            int[] nums = {0};
            _78_Subsets t = new _78_Subsets();
            t.subsets2(nums);
    }
}
