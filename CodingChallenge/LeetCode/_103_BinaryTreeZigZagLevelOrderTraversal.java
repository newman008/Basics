package LeetCode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _103_BinaryTreeZigZagLevelOrderTraversal {
	public class TreeNode {
	    int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) return results;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        s.push(root);
        boolean isEven = false;
        
        while(!s.isEmpty()) {
            TreeNode t = s.pop();
            res.add(t.val);
            if(isEven) {
                if(t.right != null) next.push(t.right);
                if(t.left != null) next.push(t.left);
            } else {
                if(t.left != null) next.push(t.left);
                if(t.right != null) next.push(t.right);
            }
            
            if(s.isEmpty()) {
                s = next;
                results.add(res);
                res = new ArrayList<Integer>();
                next = new Stack<TreeNode>();
                isEven = !isEven;
            }
        }
        
        return results;
    }
}
