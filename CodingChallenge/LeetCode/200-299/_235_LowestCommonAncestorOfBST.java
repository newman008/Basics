package LeetCode2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class _235_LowestCommonAncestorOfBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
    
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        
        return root;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
