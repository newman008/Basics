package LeetCode2;

/*
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
 */

public class _250_CountUnivalueSubtrees {
	
	public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    
    private boolean helper(TreeNode root, int[] count) {
        if(root == null) return true;
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if(left && right) {
            if(root.left != null && root.left.val != root.val)
                return false;
            if(root.right != null && root.right.val != root.val)
                return false;
            count[0]++;
            return true;
        } else 
            return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
