package LeetCode2;

public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        // two pointers
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while(i < j) {
            max = Math.max(max, (j-i) * (height[i] < height[j] ? height[i] : height[j]));
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}
