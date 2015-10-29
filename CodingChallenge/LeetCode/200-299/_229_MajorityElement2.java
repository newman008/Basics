package LeetCode2;

/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */

import java.util.*;

public class _229_MajorityElement2 {
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(int num : nums) {
            if(count1 == 0) num1 = num;
            if(count2 == 0 && num != num1) num2 = num;
            
            if(num == num1) count1++;
            else if(num == num2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == num1) count1++;
            else if(num == num2) count2++;
        }
        
        if(count1 > nums.length / 3) res.add(num1);
        if(count2 > nums.length / 3) res.add(num2);
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
