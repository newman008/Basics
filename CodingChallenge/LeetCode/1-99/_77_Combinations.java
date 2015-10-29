package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        backtrack(results, res, 1, n, k);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, List<Integer> res, int index, int n, int k) {
        if(res.size() == k) {
            results.add(new ArrayList<Integer>(res));
            return;
        }
        for(int i = index; i <= n; i++) {
            res.add(i);
            backtrack(results, res, i+1, n, k);
            res.remove(res.size() - 1);
        }
    }
}
