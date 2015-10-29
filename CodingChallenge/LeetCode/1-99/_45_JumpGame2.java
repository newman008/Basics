package LeetCode2;

public class _45_JumpGame2 {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int last = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > last) {
                last = max;
                step++;
            }
            max = Math.max(max, i + nums[i]);
        }
        return step;
    }
}
