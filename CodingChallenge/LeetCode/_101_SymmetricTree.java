package LeetCode2;

import java.util.Stack;

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}

public class _101_SymmetricTree {
	
	// recursive
	public boolean isSymmetricR(TreeNode root) {
		if(root == null) return true;
		return isMirror(root.left, root.right);
	}
    
	public boolean isMirror(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.val == right.val) {
		    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
		} else {
		    return false;
		}
	}
    
	// iterative
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		
		while(!stack.isEmpty()) {
			TreeNode p1 = stack.pop();
			TreeNode p2 = stack.pop();
			
			if(p1 == null && p2 == null) continue;
			if(p1 == null || p2 == null) return false;
			if(p1.val == p2.val) {
				stack.push(p1.left);
				stack.push(p2.right);
				stack.push(p1.right);
				stack.push(p2.left);
			} else {
				return false;
			}
		}
		
		return true;
	}
}
