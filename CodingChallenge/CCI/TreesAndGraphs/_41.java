package TreesAndGraphs;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this
question, a balanced tree is defined to be a tree such that the heights of the two
subtrees of any node never differ by more than one.
 */

class TreeNode {
    int val;
 	TreeNode left;
 	TreeNode right;
 	TreeNode(int x) { val = x; }
}

public class _41 {
	
	public boolean isBalanced(TreeNode root) {
		if(getHeight(root) == -1) return false;
		else return true;
	}
	
	public int getHeight(TreeNode root) {
		if(root == null) return 0;
		int lh = getHeight(root.left);
		if(lh == -1) return -1;
		int rh = getHeight(root.right);
		if(rh == -1) return -1;
		
		int diff = Math.abs(lh - rh);
		if(diff > 1) return -1;
		else return Math.max(lh, rh) + 1;
	}

}
