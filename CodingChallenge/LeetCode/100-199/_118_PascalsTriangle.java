package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if(numRows == 0) return results;
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) res.add(1);
                else 
                    res.add(results.get(i-1).get(j-1) + results.get(i-1).get(j));
            }
            
            results.add(res);
            res = new ArrayList<Integer>();
        }
        return results;
    }
}
