package LeetCode2;

import java.util.HashMap;

public class _3_LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
        for(int i = 0, j = 0; i < s.length(); i++) {
        		if(map.containsKey(s.charAt(i))) {
        			j = Math.max(j, map.get(s.charAt(i)) + 1);
        		}
        		map.put(s.charAt(i), i);
        		max = Math.max(max, i-j+1);
        }
        
		return max;
    }
}
