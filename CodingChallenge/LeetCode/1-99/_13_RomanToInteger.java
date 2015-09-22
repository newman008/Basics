package LeetCode2;

public class _13_RomanToInteger {
	public int romanToInt(String s) {
		char[] c = s.toCharArray();
		int l = c.length;
		int res = 0;
		for(int i = l-1; i >=0; i--) {
			switch(c[i]) {
			case 'M':
				res += 1000;
				break;
			case 'D':
				res += 500;
				break;
			case 'C':
				res += res >= 500 ? -100 : 100;
				break;
			case 'L':
				res += 50;
				break;
			case 'X':
				res += res >= 50 ? -10 : 10;
				break;
			case 'V':
				res += 5;
				break;
			case 'I':
				res += res >= 5 ? -1 : 1;
				break;
			}
		}
		
		return res;
    }
}
