package LeetCode2;

import java.util.Arrays;

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
