package LeetCode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTravesal {
    
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                TreeNode t = stack.pop();
                res.add(t.val);
                p = t.right;
            }
        }
        return res;
    }
}
