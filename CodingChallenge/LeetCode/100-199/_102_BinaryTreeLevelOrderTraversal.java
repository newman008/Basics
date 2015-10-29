package LeetCode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _102_BinaryTreeLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) return results;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        List<Integer> result = new ArrayList<Integer>();
        
        while(!q.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<TreeNode>();
            for(TreeNode t : q) {
                result.add(t.val);
                if(t.left != null) next.offer(t.left);
                if(t.right != null) next.offer(t.right);
            }
            results.add(result);
            result = new ArrayList<Integer>();
            q = new LinkedList<TreeNode>(next);
        }
        
        return results;
    }
}
