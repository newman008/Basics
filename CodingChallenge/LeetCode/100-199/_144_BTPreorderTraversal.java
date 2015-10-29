package LeetCode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode2._100_SameTree.TreeNode;

public class _144_BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        
        return res;
    }
}
