package TreesAndGraphs;

import java.util.*;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class _44 {
	
	public ArrayList<LinkedList<TreeNode>> createLinkedLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		if(root != null) {
			cur.add(root);
		}
		
		while(cur.size() != 0) {
			res.add(cur);
			LinkedList<TreeNode> pre = cur;
			cur = new LinkedList<TreeNode>();
			for(TreeNode node : pre){
				if(node.left != null) cur.add(node.left);
				if(node.right != null) cur.add(node.right);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
