package ArraysAndStrings;

import java.util.Arrays;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */

public class _13 {
	
	public boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		return sort(s1).equals(sort(s2));
	}
	
	public String sort(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	
	public boolean isPermutation2(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] count = new int[256];
		
		char[] c = s.toCharArray();
		for(char ch : c){
			count[ch]++;
		}
		
		for(int i = 0; i < t.length(); i++) {
			if(--count[t.charAt(i)] < 0) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_13 t = new _13();
		System.out.println(t.isPermutation2("abcds", "abdcs"));
	}

}
