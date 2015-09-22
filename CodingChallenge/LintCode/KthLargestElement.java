package lintCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for(int num : nums) {
            pq.add(num);
        }
        
        for(int i = 0; i < pq.size() - 1; i++)
            pq.poll();
        
        return pq.peek();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElement t = new KthLargestElement();
		int[] nums = new int[]{2,1};
		t.findKthLargest(nums, 1);
	}

}
