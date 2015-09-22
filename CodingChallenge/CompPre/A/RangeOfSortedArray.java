package Amazon;

import java.util.*;
/*
 * coding: 把一串连续的整数表示为一个range, range包含begin和end.比如3,4,5,6就表示为begin=3,end=6的range..
 * 一个排好序的整数数组，返回所有的range. 
 * 比如1,2,3,5,7,8,10返回[1,3],[5,5],[7,8],[10,10] follow up是用迭代器实现。。。
 */

class Range {
	int begin;
	int end;
	
	public Range(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
}

public class RangeOfSortedArray {
	
	public Range getRange(int[] nums) {
		return new Range(nums[0], nums[nums.length - 1]);
	}
	
	public List<Range> getAllRanges(int[] nums) {
		List<Range> res = new ArrayList<Range>();
		int begin = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i-1] + 1) {
				res.add(new Range(begin, nums[i-1]));
				begin = nums[i];
			}
		}
		res.add(new Range(begin, nums[nums.length - 1]));
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,5,7,8,10};
		int[] nums2 =  {1,2,3,5,7,8,9};
		RangeOfSortedArray t = new RangeOfSortedArray();
		for(Range r : t.getAllRanges(nums)){
			System.out.print(r.begin + " " + r.end);
			System.out.println();
		}
	}

}
