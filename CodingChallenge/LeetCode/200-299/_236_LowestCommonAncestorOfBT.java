package LeetCode2;

public class _236_LowestCommonAncestorOfBT {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        else return left == null? right : left;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
