package LeetCode2;

public class _222_CountCompleteTreeNodes {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = 0;
        int rh = 0;
        TreeNode cur = root;
        while(cur != null) {
            cur = cur.left;
            lh++;
        }
        cur = root;
        while(cur != null) {
            cur = cur.right;
            rh++;
        }
        if(lh == rh) return (2 << lh-1) - 1;
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
