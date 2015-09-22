package LeetCode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _187_RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> repeated = new HashSet<Integer>();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('A', 0);
	    map.put('C', 1);
	    map.put('G', 2);
	    map.put('T', 3);
        
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i+10; j++) {
                v = v << 2;
                v = v | map.get(s.charAt(j));
            }
            if(!set.add(v) && repeated.add(v))
                res.add(s.substring(i, i+10));
        }
        
        return res;
    }
}
