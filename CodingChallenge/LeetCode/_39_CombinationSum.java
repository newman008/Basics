package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(results, result, 0, candidates, target);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> result, int index, int[] candidates, int target) {
        if(target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        // if(index == candidates.length || candidates[index] > target) return;

        // result.add(candidates[index]);
        // backtrack(results, result, index, candidates, target - candidates[index]);
        // result.remove(result.size() - 1);

        // backtrack(results, result, index+1, candidates, target);
        for(int i = index; i < candidates.length && candidates[i] <= target; i++) {
            result.add(candidates[i]);
            backtrack(results, result, i, candidates, target - candidates[i]);
            result.remove(result.size() - 1);
        }
    }
}
