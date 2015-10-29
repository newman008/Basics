package LeetCode2;

public class _129_SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int sum) {
        if(root.left == null && root.right == null) 
            return sum*10 + root.val;
        return (root.left == null ? 0 : dfs(root.left, 10 * sum + root.val)) + (root.right == null ? 0 : dfs(root.right, 10 * sum + root.val));
    }
}
