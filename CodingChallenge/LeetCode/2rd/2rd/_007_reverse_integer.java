package leetcode;

/** Problem:
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

/** Analysis:
 * What if x = 100, return 001?
 * What if reversed x is overflowed? 
 * Time  complexity: O(N)
 * Space complexity: O(1)
*/

import java.util.*;

public class _007_reverse_integer {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        int num = sign * x;
        int res = 0;

        while(num > 0) {
            if(res > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + num % 10;
            num = num / 10;
        }

        return res * sign;
    }

    public static void main(String[] args) {
        _007_reverse_integer s = new _007_reverse_integer();
        System.out.println(s.reverse(-123));
    } 
}


