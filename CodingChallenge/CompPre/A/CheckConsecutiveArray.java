package Amazon;

public class CheckConsecutiveArray {

    public static boolean isConsecutive(int[] nums) {
        int max = getMax(nums);
        int min = getMin(nums);
        int n = nums.length;
        
        if(max - min + 1 != n) return false;
        else {
            boolean[] visited = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(visited[nums[i] - min]) return false;
                else visited[nums[i] - min] = true;
            }
            return true;
        }
    }
    
    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums)
            if(num > max) max = num;
        return max;
    }
    
    private static int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) 
            if(num < min) min = num;
        return min;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2, 3, 4, 5, 1, 0};
        System.out.println(CheckConsecutiveArray.isConsecutive(nums));
    }

}
