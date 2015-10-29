package LeetCode2;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */

import java.util.*;

public class _266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        int count = 0;
        boolean res = true;
        for(char key : map.keySet()){
            if(map.get(key) % 2 != 0) {
                count++;
                if(count > 1) {
                    res = false;
                    break;
                }
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
