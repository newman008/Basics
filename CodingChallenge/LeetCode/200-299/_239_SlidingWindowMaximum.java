package LeetCode2;

import java.util.*;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
 */

public class _239_SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1) return new int[]{};
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dp = new LinkedList<Integer>();
        
        for(int i = 0; i < k; i++) {
            while(!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]){
                dp.pollLast();
            }
            dp.offerLast(i);
        }
        res[0] = nums[dp.peekFirst()];
        
        for(int i = k; i < nums.length; i++) {
            if(!dp.isEmpty() && dp.peekFirst() == i-k) dp.pollFirst();
            
            while(!dp.isEmpty() && nums[i] >= nums[dp.peekLast()]){
                dp.pollLast();
            }
            dp.offerLast(i);
            
            res[i-k+1] = nums[dp.peekFirst()];
        }
        
        return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
