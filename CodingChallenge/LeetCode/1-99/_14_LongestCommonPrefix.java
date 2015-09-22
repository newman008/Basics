package LeetCode2;

public class _14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		char[] c = strs[0].toCharArray();
		int l = strs[0].length();
		for(int i = 0; i < l; i++) {
			for(int j = 1; j < strs.length; j++) {
				if(strs[j].length() == i || c[i] != strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
    }
}
