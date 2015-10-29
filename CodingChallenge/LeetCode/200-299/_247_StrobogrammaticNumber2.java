package LeetCode2;

import java.util.*;

public class _247_StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int cur, int n) {
        
        if (cur == 0) return new ArrayList<String>(Arrays.asList(""));
        if (cur == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> res = new ArrayList<String>();
        for(String str : helper(cur - 2, n)) {
            if(cur != n) res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        
        return res;

    }
}
