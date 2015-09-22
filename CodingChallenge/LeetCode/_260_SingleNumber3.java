package LeetCode2;

public class _260_SingleNumber3 {
	public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        
        int mask = 1;
        while((xor & mask) == 0){
            mask = mask << 1;
        }
        
        for(int num : nums) {
            if((num & mask) == 0)
                res[0] = res[0] ^ num;
            else
                res[1] = res[1] ^ num;
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
