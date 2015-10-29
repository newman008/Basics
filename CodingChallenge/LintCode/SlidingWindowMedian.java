package lintCode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class SlidingWindowMedian {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || k < 1) return res;
        
        
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
                @Override
                public int compare(Integer x, Integer y) {
                    return y.compareTo(x);
                }
            });
        
        for(int i = 0; i < k; i++) {
            if(min.size() - max.size() < 2) {
                min.add(nums[i]);
            } else {
                min.add(nums[i]);
                max.add(min.poll());
            }
        }
        
        res.add(min.peek());
        
        for(int i = k; i < nums.length; i++) {
            max.remove(nums[i-k]);
            min.remove(nums[i-k]);
            
            if(min.size() - max.size() < 2) {
                min.add(nums[i]);
            } else {
                min.add(nums[i]);
                max.add(min.poll());
            }
            
            res.add(min.peek());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SlidingWindowMedian t = new SlidingWindowMedian();
        int[] nums = {142,38,100,53,22,84,168,50,194,136,111,13,47,45,151,164,126,47,106,124,183,8,87,38,91,121,102,46,82,195,53,18,11,165,61};
        t.medianSlidingWindow(nums, 35);
    }

}
