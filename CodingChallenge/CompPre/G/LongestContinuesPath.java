package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class LongestContinuesPath {
	
	class TreeNode {
		int val;
		List<TreeNode> children = new ArrayList<TreeNode>();
	}
	
	public int longestContinuousPath(TreeNode root) {
		if(root == null) return 0;
		return longestContinuousPath(root, 1);
	}
	
	public int longestContinuousPath(TreeNode node, int len) {
		int max = 0;
		for(TreeNode child : node.children) {
			if(child == null) continue;  
			int curLen = longestContinuousPath(child, child.val == node.val + 1? len + 1: 1);
			max = Math.max(max, curLen);
		}
		return Math.max(max, len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
