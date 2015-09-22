package LeetCode2;

public class _28_ImplementStrstr {
	public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
