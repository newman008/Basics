package LeetCode2;

import java.util.Arrays;
import java.util.Comparator;

public class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        int l = nums.length;
        String[] caches = new String[l];
        for (int i = 0; i < l; i++) 
            caches[i] = String.valueOf(nums[i]);
        
        Arrays.sort(caches, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        StringBuilder res = new StringBuilder();
        for(String str : caches) {
            res.append(str);
        }
        
        if(res.charAt(0) == '0') return "0";
        
        return res.toString();
    }
}
