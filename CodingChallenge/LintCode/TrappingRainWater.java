package lintCode;

public class TrappingRainWater {
	
	public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) return 0;
        
        int l = heights.length;
        int[] left = new int[l];
        int[] right = new int[l];
        // int[] bottlenect = new int[l];
        
        int leftMax = 0;
        for(int i = 1; i < l; i++) {
            if(left[i-1] > leftMax) leftMax = left[i-1];
            left[i] = leftMax;
        }
        //printArray(left);
        
        int rightMax = 0;
        for(int i = l - 2; i >= 0; i--) {
            if(right[i+1] > rightMax) rightMax = right[i+1];
            right[i] = rightMax;
        }
        //printArray(right);
        
        int res = 0;
        for(int i = 0; i < l; i++) {
            if(Math.min(left[i], right[i]) - heights[i] > 0)
                res = res + Math.min(left[i], right[i]) - heights[i];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater t = new TrappingRainWater();
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(t.trapRainWater(array));
	}
	
	public void printArray(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

}
