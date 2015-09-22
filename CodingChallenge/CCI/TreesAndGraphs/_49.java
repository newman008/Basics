package TreesAndGraphs;

/*
 * You are given a binary tree in which each node contains a value. Design an algorithm
to print all paths which sum to a given value. The path does not need to start
or end at the root or a leaf.
 */

public class _49 {
	
	public void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	private int depth(TreeNode node) {
		if(node == null) {
			return 0;
		} else {
			return depth(node.left) + depth(node.right) + 1;
		}
	}
	
	public static void print(int[] path, int start, int end) {
		for(int i = start; i <= end; i++){
			System.out.print(path[i]);
		}
		System.out.println();
	}
	
	public void findSum(TreeNode node, int sum, int[] path, int level) {
		if(node == null) return;
		
		path[level] = node.val;
		int t = 0;
		for(int i = level; i >= 0; i--) {
			t += path[i];
			if(t == sum) print(path, i, level);
		}
		
		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);
		
		path[level] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
