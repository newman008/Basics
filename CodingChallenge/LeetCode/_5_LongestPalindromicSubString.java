package LeetCode2;

public class _5_LongestPalindromicSubString {
	private int len = 0;
	private int index = 0;
	
	public String longestPalindrome(String s) {
        int length = s.length();
		for(int i = 0; i < s.length(); i++) {
        		expand(s, length, i, i);
        		expand(s, length, i, i+1);
        }
        return s.substring(index, index+len);
    }
	
	public void expand(String s, int length, int left, int right) {
		while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
			if(right - left + 1 > len) {
				len = right - left + 1;
				index = left;
			}
			left--;
			right++;
		}
	}
}
