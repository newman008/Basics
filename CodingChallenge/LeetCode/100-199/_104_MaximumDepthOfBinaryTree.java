package LeetCode2;

import java.util.LinkedList;
import java.util.Queue;

public class _104_MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     else
    //         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    // }
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        q.offer(root);
        int depth = 0;
        
        while(!q.isEmpty()){
            for(TreeNode t : q) {
                if(t.left != null) next.offer(t.left);
                if(t.right != null) next.offer(t.right);
            }
            depth++;
            q = new LinkedList<TreeNode>(next);
            next = new LinkedList<TreeNode>();
        }
        
        return depth;
    }
}
