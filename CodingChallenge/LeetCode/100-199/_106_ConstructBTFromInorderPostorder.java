package LeetCode2;

import LeetCode2._104_MaximumDepthOfBinaryTree.TreeNode;

public class _106_ConstructBTFromInorderPostorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    
    public TreeNode helper(int index, int start, int end, int[] inorder, int[] postorder) {
        if(index < 0 || start > end) return null;
        
        TreeNode root = new TreeNode(postorder[index]);
        int mid = 0;
        for(int i = start; i <= end; i++) {
            if(inorder[i] == root.val) mid = i;
        }
        
        root.right = helper(index-1, mid+1, end, inorder, postorder);
        root.left = helper(index-end+mid-1, start, mid-1, inorder, postorder);
        
        return root;
    }
}
