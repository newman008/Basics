package TreesAndGraphs;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height.
 */

public class _43 {
	
	public TreeNode convertBST(int[] nums) {
		return convertBST(nums, 0, nums.length - 1);
	}
	
	public TreeNode convertBST(int[] nums, int start, int end) {
		if(start > end) return null;
		int mid = start + (end - start) / 2;
		int midNum = nums[mid];
		TreeNode root = new TreeNode(midNum);
		root.left = convertBST(nums, start, mid-1);
		root.right = convertBST(nums, mid + 1, end);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
