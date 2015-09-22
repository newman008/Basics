package InterviewQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleNumber {
	
	public List<List<Integer>> findTripleNumbers(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums);
		backtrack(results, res, nums, target, 0);
		return results;
	}
	
	private void backtrack(List<List<Integer>> results, List<Integer> res, int[] nums, int target, int index) {
		if(target <= 0) return;
		if(res.size() == 3 && target > 0) {
			results.add(new ArrayList<Integer>(res));
			return;
		}
		
		for(int i = index; i < nums.length; i++) {
			res.add(nums[i]);
			backtrack(results, res, nums, target - nums[i], i+1);
			res.remove(res.size() - 1);
		}
	}
	
	public List<List<Integer>> findThreeNums(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < target) {
				int sum = target - nums[i];
				
				int j = i + 1;
				int k = nums.length - 1;
				while(j < k) {
					if(nums[j] + nums[k] >= sum) k--;
					else {
						for(int t = k; t > j; t--) {
							results.add(Arrays.asList(nums[i], nums[j], nums[t]));
						}
						j++;
					}
				}

			}
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripleNumber t = new TripleNumber();
		int[] nums = new int[]{2, 4, 6, 3, 13};
//		List<List<Integer>> results = t.findTripleNumbers(nums, 13);
		List<List<Integer>> results = t.findThreeNums(nums, 13);
		for(List<Integer> lst : results) {
			for(int num : lst) {
				System.out.print(num);
			}
			System.out.println();
		}
	}

}
