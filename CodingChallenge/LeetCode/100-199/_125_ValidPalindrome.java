package LeetCode2;

public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z^0-9]", "");
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
