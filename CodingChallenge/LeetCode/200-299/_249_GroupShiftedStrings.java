package LeetCode2;

/*
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */

import java.util.*;

public class _249_GroupShiftedStrings {
    
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for(int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if(c < 'a') 
                    c = (char) (c + 26);
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        
        for(String s : map.keySet()){
            List<String> list = map.get(s);
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
