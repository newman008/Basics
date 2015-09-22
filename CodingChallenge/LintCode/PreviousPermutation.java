package lintCode;

import java.util.ArrayList;

public class PreviousPermutation {
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		boolean flag = false;
		
		for(int i = nums.size() - 2; i >= 0; i--){
		    if(nums.get(i) > nums.get(i+1)) {
		        flag = true;
		        for(int j = nums.size() - 1; j > i; j--){
		            if(nums.get(j) < nums.get(i))
		                swap(nums, i, j);
		        }
		        reverse(nums, i+1, nums.size() - 1);
		        break;
		    }
		}
		
		if(!flag) return reverse(nums, 0, nums.size() - 1);
		return nums;
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
    
    private ArrayList<Integer> reverse(ArrayList<Integer> nums, int i, int j) {
        if(i == j) return nums;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        return nums;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreviousPermutation p = new PreviousPermutation();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(1);
		nums.add(2);
		p.previousPermuation(nums);
	}

}
