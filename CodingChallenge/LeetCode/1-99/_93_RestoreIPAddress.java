package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddress {
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<String>();
        backtrack(res, s, "", 0, 1);
        return res;
    }
    
    public void backtrack2(List<String> res, String s, String cur, int index, int segment) {
        if(index >= s.length()) return;
        if(segment == 4) {
            String str = s.substring(index);
            if(isValid(str)) {
                res.add(cur + '.' + str);
            }
            return;
        }
        
        for(int i = 1; i < 4 && (index+i < s.length()); i++) {
            String str = s.substring(index, index+i);
            if(isValid(str)) {
                if(segment == 1) {
                    backtrack(res, s, str, index+i, segment+1);
                } else {
                    backtrack(res, s, cur + '.' + str, index+i, segment+1);
                }
            }
        }
        
    }
    
    public boolean isValid(String s) {
        if(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0)
            return false;
        return true;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        
        String path = new String();
        backtrack(res, path, s, 0, 0);
        
        return res;
    }
    
    private void backtrack(List<String> res, String path, String s, int index, int count) {
        //if(index > s.length()) return;
        if(count == 4) {
            if(index == s.length()){
                res.add(path);
            }
            return;
        }
        
        for(int i = 1; i < 4 && index+i < s.length(); i++) {
            String str = s.substring(index, index+i);
            if(isValid(str)){
                if(count == 0)
                    backtrack(res, str, s, index+i, count + 1);
                else
                    backtrack(res, path + "." + str, s, index+i, count + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            _93_RestoreIPAddress t = new _93_RestoreIPAddress();
        t.restoreIpAddresses("0000");
    }
}
