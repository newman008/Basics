package lintCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfPhoneNumber {
private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;
        res.add(new String(""));
        backtrack(res, digits, 0);
        return res;
    }
    
    private void backtrack(List<String> res, String digits, int index) {
        if(index == digits.length()) {
            return;
        }
        
        String cur = keys[digits.charAt(index) - '0'];
        List<String> tmp = new ArrayList<String>();
        for(String str : res) {
            for(int i = 0; i < cur.length(); i++){
                tmp.add(str + cur.charAt(i));
            }
        }
        
        res = tmp;
        backtrack(res, digits, index+1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CombinationOfPhoneNumber t = new CombinationOfPhoneNumber();
        t.letterCombinations("2");
    }

}
