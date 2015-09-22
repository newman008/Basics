package LeetCode2;

public class _114_FlattenBTToLinkedList {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            root.left = null;
            root.right = leftNode;
            TreeNode p = leftNode;
            while(p.right != null) {
                p = p.right;
            }
            p.right = rightNode;
        }
        flatten(root.right);
    }
}
