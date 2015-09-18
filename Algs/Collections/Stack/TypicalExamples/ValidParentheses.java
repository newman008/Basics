/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else if(s.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(')
                st.pop();
            else if(s.charAt(i) == '}' && !st.isEmpty() && st.peek() == '{')
                st.pop();
            else if(s.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[')
                st.pop();
            else
                return false;
        }
        
        return st.isEmpty();
    }
}