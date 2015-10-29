package LeetCode2;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
