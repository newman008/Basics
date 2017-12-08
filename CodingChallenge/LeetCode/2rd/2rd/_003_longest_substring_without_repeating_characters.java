package leetcode;

/** Problem:
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/** Analysis:
Time  complexity: O(n)
Space complexity: O(min(m, n))
*/

import java.util.*;

public class _003_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // map between Character and its index

        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if(map.containsKey(cur)) {
                i = Math.max(map.get(cur) + 1, i);
            }
            map.put(cur, j);
            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        _003_longest_substring_without_repeating_characters s = new _003_longest_substring_without_repeating_characters();
        System.out.println(s.lengthOfLongestSubstring("bbbbbbb"));
    } 
}
