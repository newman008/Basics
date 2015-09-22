package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        backtrack(results, result, 0, nums, visited);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> result, int index, int[] nums, boolean[] visited) {
        if(index == nums.length) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result.add(nums[i]);
                backtrack(results, result, index+1, nums, visited);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
            
        }
    }
}
