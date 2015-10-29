package TreesAndGraphs;

/*
 * Imp/emen t a function to check if a binary tree is a binary search tree.
 */

public class _45 {
    
    public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean checkBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        
        if(root.val < min || root.val > max) return false;
        
        return checkBST(root.left, min, root.val) && checkBST(root.right, max, root.val);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
