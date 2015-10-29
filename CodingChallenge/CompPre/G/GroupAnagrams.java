package InterviewQuestions;

import java.io.*;
import java.util.*;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs) {
            String tmp = encode(str);
            if(map.containsKey(tmp)){
                map.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(tmp, list);
            }
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        
        return res;
    }
    
    public String encode(String str) {
        char[] chrr = str.toCharArray();
        // NlgN
        // Arrays.sort(chrr);
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < chrr.length; i++) {
            if(map.containsKey(chrr[i])){
                map.put(chrr[i], map.get(chrr[i]) + 1);
            } else{
                map.put(chrr[i], 1);
            }
        }
        
        for(char i = 'a'; i <= 'z'; i++) {
            if(map.containsKey(i)){
                sb.append(i);
                sb.append(map.get(i));
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
    }

}
