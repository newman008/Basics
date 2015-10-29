package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBST2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    
    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start > end) {
            res.add(null);
            return res;
        }
        
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = genTrees(start, i-1);
            List<TreeNode> right = genTrees(i+1, end);
            for(TreeNode lnode : left) {
                for(TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
