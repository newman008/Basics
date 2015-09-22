package InterviewQuestions;
// 找出二叉查找树中出现频率最高的元素。树中结点满足left->val <= root->val <= right->val。
// 如果多个元素出现次数相等，返回最小的元素。

public class FrequencyOfBST {
	
	public int HighFre(int[] nums) {
		int count = 1;
		int val = nums[0];
		int max = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				count++;
			} else {
				if(count > max) {
					val = nums[i-1];
					max = count;
				}
				count = 1;
			}
		}
		if(count > max) {
			val = nums[nums.length-1];
			max = count;
		}
		
		return val;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5};
		FrequencyOfBST t = new FrequencyOfBST();
		System.out.print(t.HighFre(nums));
		
	}

}
