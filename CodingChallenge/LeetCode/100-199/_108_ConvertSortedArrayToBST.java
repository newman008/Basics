package LeetCode2;

public class _108_ConvertSortedArrayToBST {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }
    
    public TreeNode helper(int start, int end, int[] nums) {
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid-1, nums);
        root.right = helper(mid+1, end, nums);
        
        return root;
    }
}
