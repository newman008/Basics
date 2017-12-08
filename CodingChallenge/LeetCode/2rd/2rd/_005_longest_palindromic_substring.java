package leetcode;

/** Problem:
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

/** Analysis:
Time  complexity: O(N^2)
Space complexity: O(1)
*/

import java.util.*;

public class _005_longest_palindromic_substring {
    
    private int start;
    private int end;
    
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, end+1);
    }

    private void expand(String s, int i, int j){
        while(i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)){
            if((j - i) > (end - start)){
                end = j;
                start = i;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
    
    } 
}


