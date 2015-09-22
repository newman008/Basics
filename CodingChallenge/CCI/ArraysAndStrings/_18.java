package ArraysAndStrings;

/*
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, si and s2, write code to check If s2 is a rotation of si 
 * using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */

public class _18 {
	
	public boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		String ss = s1 + s1;
		return isSubstring(ss, s2);
	}
	
	private boolean isSubstring(String ss, String s) {
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
