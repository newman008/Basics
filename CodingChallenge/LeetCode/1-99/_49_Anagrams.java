package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String cur = new String(temp);
            if(map.containsKey(cur)) {
                res.add(strs[i]);
                if(map.get(cur) >= 0){
                    res.add(strs[map.get(cur)]);
                    map.put(cur, -1);
                }
            } else {
                map.put(cur, i);
            }
        }
        
        return res;
    }
}
