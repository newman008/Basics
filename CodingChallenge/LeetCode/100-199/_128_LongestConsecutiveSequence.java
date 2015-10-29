package LeetCode2;

import java.util.HashMap;

public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum = left + right + 1;
                max = Math.max(max, sum);
                map.put(n, sum);
                
                map.put(n-left, sum);
                map.put(n+right, sum);
            }
            else {
                continue;
            }
        }
        
        return max;
    }
}
