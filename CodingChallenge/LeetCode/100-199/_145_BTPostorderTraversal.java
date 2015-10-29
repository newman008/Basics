package LeetCode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode2._100_SameTree.TreeNode;

public class _145_BTPostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur != null){
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode peekNode = stack.peek(); 
                if(peekNode.right!=null && pre != peekNode.right)  
                {  
                    cur = peekNode.right;  
                }  
                else {
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        
        return res;
    }
}
