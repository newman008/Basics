package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> res = new ArrayList<String>();
        backtrack(results, res, 0, s);
        return results;
    }
    
    public void backtrack(List<List<String>> results, List<String> res, int index, String s) {
        if(index == s.length()) {
            results.add(new ArrayList<String>(res));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                if(i == index) {
                    res.add(Character.toString(s.charAt(i)));
                } else {
                    res.add(s.substring(index, i+1));
                }
                backtrack(results, res, i+1, s);
                res.remove(res.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        if(l==r) return true;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
