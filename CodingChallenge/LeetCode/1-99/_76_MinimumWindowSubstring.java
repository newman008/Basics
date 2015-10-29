package LeetCode2;

import java.util.HashMap;

public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLen = s.length();
        int minStart = 0;
        int minEnd = s.length() - 1;
        int count = t.length();
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < count; i++) {
            if(map.containsKey(t.charAt(i))) map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            else
                map.put(t.charAt(i), 1);
        }
        
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                if(map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            
            if(count == 0) {
                while(!map.containsKey(s.charAt(left)) || map.get(s.charAt(left)) < 0) {
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
                
                if(right - left + 1 < minLen) {
                    minStart = left;
                    minEnd = right;
                    minLen = right - left + 1;
                }
            }
        }
        
        if(count != 0) return "";
        return s.substring(minStart, minEnd+1);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _76_MinimumWindowSubstring t = new _76_MinimumWindowSubstring();
        t.minWindow("bba", "ab");
    }
}
