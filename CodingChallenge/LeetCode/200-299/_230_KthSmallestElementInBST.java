package LeetCode2;

import java.util.Stack;

public class _230_KthSmallestElementInBST {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	class ModifiedTreeNode {
        int val;
        int count;
        ModifiedTreeNode left;
        ModifiedTreeNode right;
        ModifiedTreeNode(int x) {val = x; count=1; }
    }
	
	public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur != null){
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                k--;
                if(k == 0) return node.val;
                cur = node.right;
            }
        }
        
        return 0;
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        ModifiedTreeNode modifiedRoot = buildModifiedTree(root);
        return kth(modifiedRoot, k);
    }
    
    private ModifiedTreeNode buildModifiedTree(TreeNode root){
        if(root == null) return null;
        ModifiedTreeNode modifiedRoot = new ModifiedTreeNode(root.val);
        modifiedRoot.left = buildModifiedTree(root.left);
        modifiedRoot.right = buildModifiedTree(root.right);
        
        if(modifiedRoot.left != null) modifiedRoot.count += modifiedRoot.left.count;
        if(modifiedRoot.right != null) modifiedRoot.count += modifiedRoot.right.count;
        
        return modifiedRoot;
    }
    
    private int kth(ModifiedTreeNode root, int k) {
        if(root.left != null) {
            if(root.left.count == k-1) return root.val;
            else if(root.left.count < k-1) return kth(root.right, k-1-root.left.count);
            else return kth(root.left, k);
        } else {
            if(k == 1) return root.val;
            else return kth(root.right, k-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
