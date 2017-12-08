package leetcode;

/** Problem:
Implement atoi to convert a string to an integer.
*/

/** Analysis:
 *  Time  complexity: O(N)
 *  Space complexity: O(1)
*/

import java.util.*;

public class _008_string_to_integer {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();

        int i = 0;
        int sign = 1;
        if(str.charAt(i) == '+') {
            i++;
        } else if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        return res * sign;
    } 

    public static void main(String[] args) {
        _008_string_to_integer s = new _008_string_to_integer();
        System.out.println(s.myAtoi("   343531#$#@"));
    } 
}


