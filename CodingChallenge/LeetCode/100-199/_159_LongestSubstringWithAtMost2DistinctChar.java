package LeetCode2;

import java.util.HashMap;

public class _159_LongestSubstringWithAtMost2DistinctChar {
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;

	    	int k = 2;
	    
	    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    	int left = 0;
	    	int max = 0;
	    	int count = 0;
	    
	    	for(int i = 0; i < s.length(); i++) {
	    		char ch = s.charAt(i);
	    		if(map.containsKey(ch)) {
	    			map.put(ch, map.get(ch) + 1);
	    		} else {
	    			count++;
	    			map.put(ch, 1);
	    			while(count > k) {
	    				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
	    				if(map.get(s.charAt(left)) == 0) {
	    					count--;
	    					map.remove(s.charAt(left));
	    				}
	    				left++;
	    			}
	    		}
	    		max = Math.max(max, i - left + 1);
	    	}
	    
	    	return max;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_159_LongestSubstringWithAtMost2DistinctChar t = new _159_LongestSubstringWithAtMost2DistinctChar();
		t.lengthOfLongestSubstringTwoDistinct("abcabcabc");
	}

}
