package LeetCode2;

public class _214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int mid = (s.length() - 1) / 2;
        String res = new String();
        for(int i = mid; i >= 0; i--) {
            if(s.charAt(i) == s.charAt(i+1)) {
                res = Palindrome(s, i, i+1);
                if(res != null) return res;
            }
            res = Palindrome(s, i, i);
            if(res != null) return res;
        }
        return res;
    }
    
    private String Palindrome(String s, int l, int r) {
        int i = l;
        int j = r;
        for(; i >= 0; i--, j++) {
            if(j >= s.length() || s.charAt(i) != s.charAt(j)) return null;
        }
        StringBuilder sb = new StringBuilder(s.substring(j));
        sb.reverse();
        return sb + s;
    }
}
