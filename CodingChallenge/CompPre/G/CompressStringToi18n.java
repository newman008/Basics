package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Generate all such possible i18n strings for any given string. 
 * for eg. "careercup"=>"c7p","ca6p","c6up","car5p","ca5up","care4p","car4up","caree3p","care3up"..
 * till the count is 0 which means its the complete string again.
 */

public class CompressStringToi18n {
    
    public static List<String> compress(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        
        int l = s.length();
        if(l <= 2) {
            res.add(s);
            return res;
        }
        
        for(int i = l-2; i >= 1; i--) {
            for(int j = 1; j + i < l; j++) {
                res.add(s.substring(0, j) + i + s.substring(i+j));
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> res = CompressStringToi18n.compress("careercup");
        for(String str : res) {
            System.out.println(str);
        }
    }

}
