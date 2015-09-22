package LeetCode2;

import java.util.Stack;

public class _20_ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else if(s.charAt(i) == ')' && !st.isEmpty() && st.pop() == '(')
                continue;
            else if(s.charAt(i) == '}' && !st.isEmpty() && st.pop() == '{')
                continue;
            else if(s.charAt(i) == ']' && !st.isEmpty() && st.pop() == '[')
                continue;
            else
                return false;
        }
        
        return st.isEmpty();
    }
}
