package LeetCode2;

public class _42_TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int[] bottleneck = new int[height.length];
        int res = 0;
        
        int leftmax = 0;
        for(int i = 0; i < height.length; i++) {
            bottleneck[i] = leftmax;
            leftmax = Math.max(leftmax, height[i]);
        }
        
        int rightmax = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            bottleneck[i] = Math.min(rightmax, bottleneck[i]);
            rightmax = Math.max(height[i], rightmax);
            res += bottleneck[i] - height[i] > 0 ? bottleneck[i] - height[i] : 0;
        }
        
        return res;
    }
    
    public int trap2(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int l = 0;
        int r = height.length - 1;
        
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        
        while(l <= r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if(leftMax <= rightMax) {
                res += leftMax - height[l];
                l++;
            }
            else {
                res += rightMax - height[r];
                r--;
            }
        }
        
        return res;
    }
}
