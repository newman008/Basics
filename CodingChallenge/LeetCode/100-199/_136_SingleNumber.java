package LeetCode2;

import java.util.HashSet;

public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            if(!set.add(n))
                set.remove(n);
        }
        return set.toArray(new Integer[0])[0].intValue();
    }
}
