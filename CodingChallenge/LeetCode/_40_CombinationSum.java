package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSum {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        backtrack(results, result, 0, candidates, target);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> result, int index, int[] candidates, int target) {
        if(target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        
        for(int i = index; i < candidates.length && candidates[i] <= target; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            result.add(candidates[i]);
            backtrack(results, result, i+1, candidates, target - candidates[i]);
            result.remove(result.size() - 1);
        }
    }
}
