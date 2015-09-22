package lintCode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    if(stack.isEmpty()) max = Math.max(max, i+1);
                    else max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses t = new LongestValidParentheses();
		t.longestValidParentheses("()");
	}

}
