package LeetCode2;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class _246_StrobogrammaticNumber {
	
	public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if(c == '9') sb.append('6');
            else if(c == '6') sb.append('9');
            else if(c == '8' || c == '1' || c == '0') sb.append(c);
            else return false;
        }
        
        return num.equals(sb.toString());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
