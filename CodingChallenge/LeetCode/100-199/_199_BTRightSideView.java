package LeetCode2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_BTRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                TreeNode cur = q.poll();
                if(i == s-1) res.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }
}
