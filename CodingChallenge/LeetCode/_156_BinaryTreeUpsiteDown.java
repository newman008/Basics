package LeetCode2;

public class _156_BinaryTreeUpsiteDown {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		if(root == null) return null;
		TreeNode parent = root;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if(left != null) {
			TreeNode res = UpsideDownBinaryTree(left);
			left.left = right;
			left.right = parent;
			return res;
		}
		
		return root;
	}
	
	public TreeNode UpsideDownBinaryTree2(TreeNode root) {
		TreeNode node = root, parent = null, right = null;
		while (node != null) {
			TreeNode left = node.left;
			node.left = right;
			right = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}
}
