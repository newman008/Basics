package LeetCode2;

import java.util.Arrays;
import java.util.Stack;

public class _84_LargestRectangleArea {
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
