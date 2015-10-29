package LeetCode2;

import java.util.Stack;

public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int longest = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else {
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if(s.charAt(stack.peek()) == '(') stack.pop();
                    else
                        stack.push(i);
                }
            }
        }
        
        if(stack.isEmpty()) return len;
        else {
            int right = len, left = 0;
            while(!stack.isEmpty()){
                left = stack.peek();
                stack.pop();
                longest = Math.max(longest, right - 1 - left);
                right = left;
            }
            longest = Math.max(longest, right);
        }
        
        return longest;
        
    }
}
