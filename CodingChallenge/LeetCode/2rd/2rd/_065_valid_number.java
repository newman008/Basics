package leetcode;

/** Problem:
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
*/

/** Analysis:
 *  Time  complexity: O(N)
 *  Space complexity: O(1)
*/

import java.util.*;

public class _065_valid_number {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;

        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasNumAfterE = true;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                hasNum = true;
                hasNumAfterE = true;
            } else if(c == '.') {
                if(hasE || hasDot) return false;
                hasDot = true;
            } else if(c == 'E' || c == 'e') {
                if(hasE || !hasNum) return false;
                hasE = true;
                hasNumAfterE = false;
            } else if(c == '+' && c == '-') {
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                    return false;
            } else 
                return false;
        }

        return hasNum && hasNumAfterE;
    }

    public static void main(String[] args) {
        _065_valid_number s = new _065_valid_number();
        System.out.println(s.isNumber("2.1e10"));
    } 
}


