package ArraysAndStrings;
/*
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structures?
 */
public class _11 {
	
	public static boolean isUnique(String s) {
		if(s.length() > 256) return false;
		
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(char_set[ch]) return false;
			char_set[ch] = true;
		}
		
		return true;
	}
	
	public static boolean isUnique2(String s) {
		if(s.length() > 26) return false;
		
		int checker = 0;
		for(int i = 0; i < s.length(); i++) {
			int cur = s.charAt(i) - 'a';
			if((checker & (1 << cur)) != 0) return false;
			checker = checker | (1 << cur);
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
