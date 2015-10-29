package lintCode;

public class TwoStringsAreAnagrams {
    public boolean anagram(String s, String t) {
        // write your code here
        if(s.length() != t.length()) return false;
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)]--;
        }
        for(int i = 0; i < 256; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TwoStringsAreAnagrams t = new TwoStringsAreAnagrams();
        String s1 = new String("abcd");
        String s2 = new String("bdac");
        boolean res = t.anagram(s1, s2);
    }
}
