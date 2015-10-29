package LeetCode2;

import java.util.LinkedList;
import java.util.Queue;

public class _111_MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right? left+1 : right+1;
    }
    
    public int minDepth2(TreeNode root) {
        // if(root == null) return 0;
        // if(root.left == null && root.right == null) return 1;
        // if(root.left == null) return minDepth(root.right)+1;
        // if(root.right == null) return minDepth(root.left)+1;
        
        // int left = minDepth(root.left);
        // int right = minDepth(root.right);
        // return left < right? left+1 : right+1;
        
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        Queue<Integer> depths = new LinkedList<Integer>();
        depths.offer(1);
        
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            int d = depths.poll();
            
            if(t.left == null && t.right == null) return d;
            if(t.left != null) {
                q.offer(t.left);
                depths.offer(d+1);
            }
            if(t.right != null) {
                q.offer(t.right);
                depths.offer(d+1);
            }
        }
        
        return 0;
    }
}
