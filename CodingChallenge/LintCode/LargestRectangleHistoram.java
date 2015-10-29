package lintCode;

import java.util.Stack;

public class LargestRectangleHistoram {
    
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        //stack.push(height[0]);
        
        int max = 0;
        int i = 0;
        for(; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] < stack.peek()){
                int cur = height[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, cur);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int cur = height[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            max = Math.max(max, cur);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LargestRectangleHistoram t = new LargestRectangleHistoram();
        int[] nums = new int[]{4, 2};
        t.largestRectangleArea(nums);
    }

}
