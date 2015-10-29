package LeetCode2;

import java.util.HashMap;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */

public class _242_ValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        char[] sa = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < sa.length; i++) {
            if(map.containsKey(sa[i])) {
                map.put(sa[i], map.get(sa[i]) + 1);
            } else {
                map.put(sa[i], 1);
            }
        }
        
        char[] ta = t.toCharArray();
        for(int i = 0; i < ta.length; i++) {
            if(map.containsKey(ta[i])) {
                if(map.get(ta[i]) == 0) return false;
                else map.put(ta[i], map.get(ta[i]) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
