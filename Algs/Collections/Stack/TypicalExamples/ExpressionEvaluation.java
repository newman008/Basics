/*
 * Given an expression string array, return the final result of this expression
 * Example:
 * For the expression 2*6-(23+7)/(1+2), input is
 * [
 *  "2", "*", "6", "-", "(",
 *  "23", "+", "7", ")", "/",
 *  (", "1", "+", "2", ")"
 * ],
 *
 * return 2
 *
 * The expression contains only integer, +, -, *, /, (, ).
 *
 */

import java.util.Stack;

public class ExpressionEvaluation {
	public int evaluateExpression(String[] expression) {
        // write your code here
        if(expression == null || expression.length == 0) return 0;
        
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> opStack = new Stack<String>();
        
        for(String str : expression) {
            if(isOps(str)){
                if(str.equals("(")){
                    opStack.push(str);
                } else if(str.equals(")")){
                    while(!opStack.peek().equals("(")) {
                        numStack.push(cal(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                    opStack.pop(); // pop "("
                } else {
                    // cur is lower than the ones in stack
                    while(!opStack.isEmpty() && order(str) <= order(opStack.peek())){
                        numStack.push(cal(numStack.pop(), numStack.pop(), opStack.pop()));
                    }
                    opStack.push(str);
                }
            } else {
                numStack.push(Integer.parseInt(str));
            }
        }
        
        while(!opStack.isEmpty()){
            numStack.push(cal(numStack.pop(), numStack.pop(), opStack.pop()));
        }
        
        return numStack.isEmpty()? 0 : numStack.pop();
        
    }
    
    private boolean isOps(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")"))
            return true;
        else
            return false;
    }
    
    private int cal(int a, int b, String op) {
        if (op.equals("+")) {  
            return a + b;  
        } else if (op.equals("-")) {  
            return b - a;  
        } else if (op.equals("*")) {  
            return a * b;  
        } else {  
            return b/a;  
        }  
    }
    
    private int order(String a) {  
        if (a.equals("*") || a.equals("/")) {  
            return 2;  
        } else if (a.equals("+") || a.equals("-")) {  
            return 1;  
        } else {  
            return 0;  
        }  
    } 
}

