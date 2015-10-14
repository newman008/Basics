package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationOfPhoneNumber {
    private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;
        bfs("", 0, digits, res);
        return res;
    }
    
    private void bfs(String pref, int index, String digits, List<String> res) {
        if(index >= digits.length()) {
            res.add(pref);
            return;
        } 
        String s = keys[digits.charAt(index) - '0'];
        for(int i = 0; i < s.length(); i++) {
            bfs(pref + s.charAt(i), index+1, digits, res);
        }
        
    }
}
