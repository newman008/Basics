package LeetCode2;

import java.util.Arrays;

public class _87_ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int l = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;
        
        for(int i = 1; i < l; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0, i), s2.substring(l-i)) && isScramble(s1.substring(i), s2.substring(0, l-i))) return true;
        }
        return false;
    }
}
