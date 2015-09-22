package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        if(n == 0) return null;
        List<String> result0 = new ArrayList<String>();
        result0.add("");
        results.add(result0);
        
        for(int i = 1; i <= n; i++) {
            List<String> result = new ArrayList<String>();
            for(int j = 0; j < i; j++) {
                for(String first : results.get(j)) {
                    for(String second : results.get(i-1-j)) {
                        result.add("(" + first + ")" + second);
                    }
                }
            }
            results.add(result);
        }
        
        return results.get(results.size() - 1);
    }
}
