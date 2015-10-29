package LeetCode2;

import java.util.*;

public class _257_BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        
        String path = new String(root.val + "");
        
        dfs(root, res, path);
        
        return res;
    }
    
    public void dfs(TreeNode root, List<String> res, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        
        if(root.left != null) {
            String leftPath = path + "->" + root.left.val;
            dfs(root.left, res, leftPath);
        }
        if(root.right != null) {
            String rightPath = path + "->" + root.right.val;
            dfs(root.right, res, rightPath);
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
