package LeetCode2;

import LeetCode2._104_MaximumDepthOfBinaryTree.TreeNode;

public class _105_ConstructBTFromPreorderInorder {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, preorder.length-1, preorder, inorder);
    }
    
    public TreeNode helper(int index, int start, int end, int[] preorder, int[] inorder) {
        if(index > preorder.length - 1 || start > end) return null;
        
        TreeNode root = new TreeNode(preorder[index]);
        
        int mid = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) mid = i;
        }
        
        root.left = helper(index + 1, start, mid - 1, preorder, inorder);
        root.right = helper(index + mid + 1 - start, mid + 1, end, preorder, inorder);
        
        return root;
    }
}
