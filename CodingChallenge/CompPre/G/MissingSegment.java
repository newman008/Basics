package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
// {3, 15, 16, 18, 80} => [0-2, 4-14, 17, 19-79, 80-99]

public class MissingSegment {
	
	public List<String> findMiss(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			res.add("0-99");
			return res;
		}
		
		int pre = -1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == pre + 1) {
				pre = nums[i];
				continue;
			} else {
				sb.append(pre+1);
				if(nums[i] != pre + 2) {
					sb.append("-");
					sb.append(nums[i] - 1);
				}
				pre = nums[i];
				res.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		
		if(pre == 98) res.add("99");
		if(pre < 98) res.add(pre+1 + "-" + 99);
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingSegment t= new MissingSegment();
		int[] nums = new int[]{0, 1, 2, 3, 15, 16, 18, 97};
		for(String str : t.findMiss(nums)){
			System.out.println(str);
		}
	}

}
