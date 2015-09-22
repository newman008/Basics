package LeetCode2;

import java.util.Stack;

public class _173_BinarySearchTreeIterator {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	Stack<TreeNode> s;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = s.pop();
        int res = node.val;
        if(node.right != null) {
            node = node.right;
            while(node != null) {
                s.push(node);
                node = node.left;
            }
        }
        
        return res;
    }
}
