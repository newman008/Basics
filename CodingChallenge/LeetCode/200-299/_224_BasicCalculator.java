package LeetCode2;

import java.util.Stack;

public class _224_BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = s.length();
        int sign = 1;
        int res = 0;
        int num = 0;
        
        for(int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
                num = 0;
            } else if(c == ')') {
                res += sign * num;
                res = stack.pop()*res;
                res += stack.pop();
                num = 0;
            }
        }
        
        if(num != 0) res += sign * num;
        return res;
    }
}
