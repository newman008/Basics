package LeetCode2;

import java.util.Arrays;
import java.util.Stack;

public class _86_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int[] h = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                h[j] = matrix[i][j] == '0' ? 0:h[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(h));
        }
        
        return max;
        
    }
    
    public int largestRectangleArea(int[] height) {
        height = Arrays.copyOf(height, height.length+1);
        int Max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int cur = height[stack.pop()] * (stack.isEmpty()? i : (i - stack.peek() - 1));
                Max = Math.max(Max, cur);
            }
            stack.push(i);
        }
        return Max;
    }
}
