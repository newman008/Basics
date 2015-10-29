package LeetCode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_BTLevelOrderTranversal2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            results.add(0, result);
            result = new ArrayList<Integer>();
            q = new LinkedList<TreeNode>(next);
        }
        
        return results;
    }
}
