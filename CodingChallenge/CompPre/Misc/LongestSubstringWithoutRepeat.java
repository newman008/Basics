package Misc;

import java.util.*;

public class LongestSubstringWithoutRepeat {
	
	public String LongestSubstringWithoutRepeat(String s) {
		if(s == null || s.length() == 0) return "";
		
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        String res = new String();
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
            		left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            if(right - left + 1 > max) {
            		max = right - left + 1;
            		res = s.substring(left, left+max);
            }
            
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeat t = new LongestSubstringWithoutRepeat();
		System.out.print(t.LongestSubstringWithoutRepeat("abcbefdf"));
	}

}
