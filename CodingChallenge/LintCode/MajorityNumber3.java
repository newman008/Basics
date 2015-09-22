package lintCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityNumber3 {
	public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else if (map.size() < k) {
                map.put(num, 1);
            } else {
                ArrayList<Integer> keys = new ArrayList<Integer>();  
                for (Integer key : map.keySet()){  
                    keys.add(key);  
                } 
                for(Integer key : keys){
                    map.put(key, map.get(key) - 1);
                    if(map.get(key) == 0)
                        map.remove(key);
                }
            }
        }
        
        ArrayList<Integer> keys = new ArrayList<Integer>();  
        for (Integer key : map.keySet()){  
            keys.add(key);  
        } 
        
        for(Integer key : keys){
            map.put(key, 0);
        }
        
        for(int num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
        }
        
        int res = 0;
        for(Integer key : keys){
            if(res < map.get(key))
                res = map.get(key);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityNumber3 t = new MajorityNumber3();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] num = {3,1,2,3,2,3,3,4,4,4};
		for(int n : num) {
			nums.add(n);
		}
		
		System.out.print(t.majorityNumber(nums, 3));
	}
}
