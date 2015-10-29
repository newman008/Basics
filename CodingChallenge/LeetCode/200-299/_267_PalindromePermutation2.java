package LeetCode2;

/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
 */

import java.util.*;

public class _267_PalindromePermutation2 {
    
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        int count = 0;
        boolean canGenerate = true;
        List<Character> chrr = new ArrayList<Character>();
        String mid = new String();
        for(char key : map.keySet()){
            if(map.get(key) % 2 != 0) {
                count++;
                if(count > 1) {
                    canGenerate = false;
                    break;
                }
                mid = key + "";
                if(map.get(key) > 1) {
                    for(int i = 0; i < map.get(key) / 2; i++)
                        chrr.add(key);
                }
            } else {
                for(int i = 0; i < map.get(key) / 2; i++)
                    chrr.add(key);
            }
        }
        
        if(!canGenerate) return res;
        
        char[] array = new char[chrr.size()];
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            array[j] = chrr.get(i);
            j++;
        }
        Arrays.sort(array);
        boolean[] visited = new boolean[chrr.size()];
        backtrack(res, new StringBuilder(), array, visited, mid);
        
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder half, char[] array, boolean[] visited, String mid) {
        if(half.length() == array.length){
            String path = half.toString() + mid + half.reverse().toString();
            res.add(path);
            return;
        }
        
        for(int i = 0; i < array.length; i++){
            if(!visited[i]) {
                if(i > 0 && array[i] == array[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                half.append(array[i]);
                backtrack(res, half, array, visited, mid);
                half.deleteCharAt(half.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _267_PalindromePermutation2 t = new _267_PalindromePermutation2();
        String s = "aabbcc";
        t.generatePalindromes(s);
    }

}
