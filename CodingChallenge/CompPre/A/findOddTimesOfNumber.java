package Amazon;

import java.util.*;

/*
 * 之后问了个算法题 给一个array 找出里面出现奇数次的数字。
 * 我先用hashmap， 后来用int[],最后小哥说 no extra space，卡住，然后就结束了
 */

public class findOddTimesOfNumber {
    
    // extra space
    public Set<Integer> numbersAppearOddTimes(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int num : nums) {
            if(res.contains(num)) res.remove(num);
            else res.add(num);
        }
        
        return res;
    }
    
    // no extra space
    public List<Integer> numbersAppearOddTimes2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<Integer>();
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                count++;
            } else {
                if(count % 2 != 0) res.add(nums[i-1]);
                count = 1;
            }
        }
        if(count % 2 != 0) res.add(nums[nums.length - 1]);
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        findOddTimesOfNumber t = new findOddTimesOfNumber();
        int[] nums = {1, 2, 3, 3 ,3, 2, 4 ,5, 5 ,6};
        for(int num : t.numbersAppearOddTimes2(nums))
            System.out.println(num);
    }

}
