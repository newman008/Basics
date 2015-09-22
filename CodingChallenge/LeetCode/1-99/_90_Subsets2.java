package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        results.add(res);
        Arrays.sort(nums);
        backtrack(results, res, 0, nums);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> res, int index, int[] nums) {
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            res.add(nums[i]);
            results.add(new ArrayList<Integer>(res));
            backtrack(results, res, i+1, nums);
            res.remove(res.size() - 1);
        }
    }
}
