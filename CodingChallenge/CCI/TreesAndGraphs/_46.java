package TreesAndGraphs;
/*
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
a binary search tree. You may assume that each node has a link to its parent.
 */

public class _46 {
	class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode parent;
	 	TreeNode(int x) { val = x; }
	}
	
	public TreeNode inorderSucc(TreeNode n) {
		if(n == null) return null;
		
		if(n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode p = n.parent;
			while(p != null && p.right == n){
				n = p;
				p = n.parent;
			}
			return p;
		}
	}
	
	private TreeNode leftMostChild(TreeNode n) {
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
}
