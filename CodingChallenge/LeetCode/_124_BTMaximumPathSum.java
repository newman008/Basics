package LeetCode2;

public class _124_BTMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
 		TreeNode right;
		TreeNode(int x) { val = x; }
 	}
	
	public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findBranchSum(root, max);
        return max[0];
    }
    
    public int findBranchSum(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = Math.max(0, findBranchSum(root.left, max));
        int right = Math.max(0, findBranchSum(root.right, max));
        
        max[0] = Math.max(max[0], root.val + left + right);
        
        return Math.max(left, right) + root.val;
    }
}
