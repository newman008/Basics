package LeetCode2;

import java.util.PriorityQueue;

public class _215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int n : nums) {
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
