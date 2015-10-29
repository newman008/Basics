package LeetCode2;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        double result = 0;
        int op2 = 0;
        int op1 = 0;
        
        for(String str : tokens) {
            if(str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 / op2);
            } else if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(op1 - op2);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
}
