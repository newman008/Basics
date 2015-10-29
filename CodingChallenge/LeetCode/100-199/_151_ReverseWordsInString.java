package LeetCode2;

import java.util.Stack;

public class _151_ReverseWordsInString {
    public String reverseWords(String s) {
        String[] tokens = s.split(" ");
        int l = tokens.length;
        Stack<String> stack = new Stack<String>();
        for(String t : tokens) {
            if(t.equals(""))
                continue;
            stack.push(t);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            if(!stack.isEmpty())
                sb.append(" ");
        }
        
        return sb.toString();
    }
}
