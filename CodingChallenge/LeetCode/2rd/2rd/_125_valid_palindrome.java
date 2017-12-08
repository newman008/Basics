package leetcode;

/** Problem:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

/** Analysis:
 *  Time  complexity: O(N)
 *  Space complexity: O(1)
*/

import java.util.*;

public class _125_valid_palindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;

        s = s.toLowerCase();
        s = s.replaceAll("[^0-9^a-z]", "");

        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _125_valid_palindrome s = new _125_valid_palindrome();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    } 
}


