package LeetCode2;

import java.util.*;

public class _163_MissingRanges {
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        
        int pre = lower - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == pre + 1){
                pre = nums[i];
                continue;
            } else {
                sb.append(pre+1);
                if(nums[i] != pre+2){
                    sb.append("->");
                    sb.append(nums[i]-1);
                }
                pre = nums[i];
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        if(pre == upper - 1) res.add(upper + "");
        else if(pre < upper - 1) res.add(pre+1 + "->" + upper);
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
