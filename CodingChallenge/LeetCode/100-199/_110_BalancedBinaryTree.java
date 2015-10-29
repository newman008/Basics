package LeetCode2;

public class _110_BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int depth = depth(root);
        if(depth == -1) return false;
        return true;
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int ld = depth(root.left);
        int rd = depth(root.right);
        if(ld == -1) return -1;
        if(rd == -1) return -1;
        if(Math.abs(ld - rd) > 1) return -1;
        return ld > rd ? ld+1 : rd+1;
    }
}
