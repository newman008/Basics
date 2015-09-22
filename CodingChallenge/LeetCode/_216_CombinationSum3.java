package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        dfs(results, res, k, n, 1);
        return results;
    }
    
    public void dfs(List<List<Integer>> results, List<Integer> res, int k, int sum, int start) {
        if(res.size() == k && sum == 0) {
            results.add(new ArrayList<Integer>(res));
            return;
        }
        if(sum <= 0) return;
        if(res.size() >= k) return;
        
        for(int i = start; i <= 9; i++) {
            res.add(i);
            dfs(results, res, k, sum-i, i+1);
            res.remove(res.size()-1);
        }
    }
}
