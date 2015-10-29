package LeetCode2;

public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int r = s.length() - 1;
        while(r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        int l = r;
        while(l >= 0 && s.charAt(l) != ' ') {
            l--;
        }
        return r-l;
    }
}
