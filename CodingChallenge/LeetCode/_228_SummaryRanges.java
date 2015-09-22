package LeetCode2;

import java.util.*;

public class _228_SummaryRanges {
	
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
        
        for(int i = 0; i < nums.length; i++) {
            int start = nums[i];    
            while(i < nums.length - 1 && nums[i+1] - nums[i] == 1){
                i++;
            }
            if(nums[i] == start){
                res.add(start + "");
            } else {
                res.add(start + "->" + nums[i]);
            }
            
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
